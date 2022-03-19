package br.com.examplekafkaproducer.configuration.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TopicProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public TopicProducer(final KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(final String topicName, final String key, final Object object){
        kafkaTemplate.send(topicName, key, object);
    }

}
