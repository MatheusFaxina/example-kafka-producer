package br.com.examplekafkaproducer.service;

import br.com.examplekafkaproducer.configuration.producer.TopicProducer;
import br.com.examplekafkaproducer.model.Person;
import br.com.examplekafkaproducer.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.UUID;

import static br.com.examplekafkaproducer.utils.MockUtils.createPerson;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    private TopicProducer topicProducer;

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    public void shouldSavePersonAndPostToTopicSuccessfullyTest() {
        ReflectionTestUtils.setField(personService, "topicName", "example-kafka-producer.person");

        final UUID uuid = UUID.fromString("064596d4-81d7-463b-8f44-1865a9314c19");
        final Person person = createPerson(uuid, "Name", "(44) 4 4444-4444", "email@gmail.com");

        when(personRepository.save(person)).thenReturn(person);

        personService.save(person);

        verify(topicProducer).send("example-kafka-producer.person", "064596d4-81d7-463b-8f44-1865a9314c19", person);
    }

}
