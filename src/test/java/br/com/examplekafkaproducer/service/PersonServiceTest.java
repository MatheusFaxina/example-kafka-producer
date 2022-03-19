package br.com.examplekafkaproducer.service;

import br.com.examplekafkaproducer.configuration.producer.TopicProducer;
import br.com.examplekafkaproducer.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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

    }

}
