package br.com.examplekafkaproducer.service;

import br.com.examplekafkaproducer.configuration.producer.TopicProducer;
import br.com.examplekafkaproducer.model.Person;
import br.com.examplekafkaproducer.repository.PersonRepository;
import br.com.examplekafkaproducer.service.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Value("${person.topic}")
    private String topicName;

    private final TopicProducer topicProducer;
    private final PersonRepository personRepository;

    public PersonServiceImpl(final TopicProducer topicProducer,
                             final PersonRepository personRepository) {
        this.topicProducer = topicProducer;
        this.personRepository = personRepository;
    }

    @Override
    public Person save(final Person person) {
        final Person personSave = personRepository.save(person);

        topicProducer.send(topicName, personSave.getUuid().toString(), personSave);

        return personSave;
    }

}
