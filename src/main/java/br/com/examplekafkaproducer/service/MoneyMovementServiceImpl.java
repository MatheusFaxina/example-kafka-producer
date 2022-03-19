package br.com.examplekafkaproducer.service;

import br.com.examplekafkaproducer.configuration.producer.TopicProducer;
import br.com.examplekafkaproducer.model.MoneyMovement;
import br.com.examplekafkaproducer.repository.MoneyMovementRepository;
import br.com.examplekafkaproducer.service.interfaces.MoneyMovementService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MoneyMovementServiceImpl implements MoneyMovementService {

    @Value("${money-movement.topic}")
    private String topicName;

    private final TopicProducer topicProducer;
    private final MoneyMovementRepository moneyMovementRepository;

    public MoneyMovementServiceImpl(final TopicProducer topicProducer,
                                    final MoneyMovementRepository moneyMovementRepository) {
        this.topicProducer = topicProducer;
        this.moneyMovementRepository = moneyMovementRepository;
    }

    @Override
    public MoneyMovement save(final MoneyMovement moneyMovement) {
        final MoneyMovement moneyMovementSave = moneyMovementRepository.save(moneyMovement);

        topicProducer.send(topicName, moneyMovementSave.getPersonUuid().toString(), moneyMovementSave);

        return moneyMovementSave;
    }

}
