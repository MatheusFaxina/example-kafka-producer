package br.com.examplekafkaproducer.configuration.serializer;

import br.com.examplekafkaproducer.model.MoneyMovement;
import br.com.examplekafkaproducer.model.Person;
import br.com.examplekafkaproducer.model.TypeMovement;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static br.com.examplekafkaproducer.utils.MockUtils.createMoneyMovement;
import static br.com.examplekafkaproducer.utils.MockUtils.createPerson;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class CustomSerializerTest {

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private CustomSerializer customSerializer;

    @Test
    public void shouldSerializeThePersonToPublishToTheTopicSuccessfullyTest() {
        final UUID personUuid = UUID.fromString("ea471725-6f67-489d-9323-48e86833d394");
        final Person person = createPerson(personUuid, "Name", "(44) 4 4444-4444", "email@gmail.com");

        final byte[] serialize = customSerializer.serialize("example-kafka-producer.person", person);

        final Person personSerialized = new Gson().fromJson(new String(serialize), Person.class);

        assertEquals("ea471725-6f67-489d-9323-48e86833d394", personSerialized.getUuid().toString());
        assertEquals("Name", personSerialized.getName());
        assertEquals("email@gmail.com", personSerialized.getEmail());
        assertEquals("(44) 4 4444-4444", personSerialized.getPhone());
    }

    @Test
    public void shouldReturnNullSerializationTest() {
        final byte[] serialize = customSerializer.serialize("example-kafka-producer.person", null);

        assertNull(serialize);
    }

    @Test
    public void shouldSerializeTheMoneyMovementToPublishToTheTopicSuccessfullyTest() {
        final UUID uuid = UUID.fromString("3f0e41e5-451f-4a21-b3b1-cac9b80f328c");
        final UUID personUuid = UUID.fromString("de2120f5-1b01-4684-855c-af479eb9e38b");
        final MoneyMovement moneyMovement = createMoneyMovement(uuid, personUuid, TypeMovement.DEPOSIT, "10");

        final byte[] serialize = customSerializer.serialize("example-kafka-producer.money-movement", moneyMovement);

        final MoneyMovement moneyMovementSerialized = new Gson().fromJson(new String(serialize), MoneyMovement.class);

        assertEquals("3f0e41e5-451f-4a21-b3b1-cac9b80f328c", moneyMovementSerialized.getUuid().toString());
        assertEquals("de2120f5-1b01-4684-855c-af479eb9e38b", moneyMovementSerialized.getPersonUuid().toString());
        assertEquals(TypeMovement.DEPOSIT, moneyMovementSerialized.getType());
        assertEquals("10", moneyMovementSerialized.getValue());
    }

}
