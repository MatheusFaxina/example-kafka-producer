package br.com.examplekafkaproducer.configuration.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.kafka.core.KafkaTemplate;

@RunWith(MockitoJUnitRunner.class)
public class TopicProducerTest {

    @Mock
    private KafkaTemplate<String, Object> kafkaTemplate;

    @InjectMocks
    private TopicProducer topicProducer;

    @Test
    public void shouldPostTheMessageToTheTopicSuccessfullyTest() {

    }

}
