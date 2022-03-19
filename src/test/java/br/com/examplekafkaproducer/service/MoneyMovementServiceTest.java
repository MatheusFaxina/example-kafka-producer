package br.com.examplekafkaproducer.service;

import br.com.examplekafkaproducer.configuration.producer.TopicProducer;
import br.com.examplekafkaproducer.repository.MoneyMovementRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MoneyMovementServiceTest {

    @Mock
    private TopicProducer topicProducer;

    @Mock
    private MoneyMovementRepository moneyMovementRepository;

    @InjectMocks
    private MoneyMovementServiceImpl moneyMovementService;

    @Test
    public void shouldSaveMoneyMovementAndPostToTopicSuccessfullyTest() {

    }

}
