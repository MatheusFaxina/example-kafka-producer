package br.com.examplekafkaproducer.configuration.producer;

import br.com.examplekafkaproducer.model.MoneyMovement;
import br.com.examplekafkaproducer.model.Person;
import br.com.examplekafkaproducer.model.TypeMovement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.UUID;

import static br.com.examplekafkaproducer.utils.MockUtils.createMoneyMovement;
import static br.com.examplekafkaproducer.utils.MockUtils.createPerson;

@RunWith(MockitoJUnitRunner.class)
public class TopicProducerTest {

    @Mock
    private KafkaTemplate<String, Object> kafkaTemplate;

    @InjectMocks
    private TopicProducer topicProducer;

    @Test
    public void shouldPostTheMessageThePersonToTheTopicSuccessfullyTest() {
        final UUID personUuid = UUID.randomUUID();
        final Person person = createPerson(personUuid, "Name", "(44) 4 4444-4444", "email@gmail.com");

        topicProducer.send("example-kafka-producer.person", personUuid.toString(), person);

        Mockito.verify(kafkaTemplate).send("example-kafka-producer.person", personUuid.toString(), person);
    }

    @Test
    public void shouldPostTheMessageTheMoneyMovementToTheTopicSuccessfullyTest1() {
        final MoneyMovement moneyMovement = createMoneyMovement(UUID.randomUUID(), UUID.randomUUID(), TypeMovement.DEPOSIT, "10");

        topicProducer.send("example-kafka-producer.money-movement", moneyMovement.getPersonUuid().toString(), moneyMovement);

        Mockito.verify(kafkaTemplate).send("example-kafka-producer.money-movement", moneyMovement.getPersonUuid().toString().toString(), moneyMovement);
    }

}
