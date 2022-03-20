package br.com.examplekafkaproducer.service;

import br.com.examplekafkaproducer.configuration.producer.TopicProducer;
import br.com.examplekafkaproducer.model.MoneyMovement;
import br.com.examplekafkaproducer.model.TypeMovement;
import br.com.examplekafkaproducer.repository.MoneyMovementRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.UUID;

import static br.com.examplekafkaproducer.utils.MockUtils.createMoneyMovement;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        ReflectionTestUtils.setField(moneyMovementService, "topicName", "example-kafka-producer.money-movement");

        final UUID uuid = UUID.fromString("064596d4-81d7-463b-8f44-1865a9314c19");
        final UUID personUuid = UUID.fromString("0b3ccf17-3615-4b46-aea2-f5e6fd458655");
        final MoneyMovement moneyMovement = createMoneyMovement(uuid, personUuid, TypeMovement.DEPOSIT, "10");

        when(moneyMovementRepository.save(moneyMovement)).thenReturn(moneyMovement);

        moneyMovementService.save(moneyMovement);

        verify(topicProducer).send("example-kafka-producer.money-movement", "0b3ccf17-3615-4b46-aea2-f5e6fd458655", moneyMovement);
    }

}
