package br.com.examplekafkaproducer.repository;

import br.com.examplekafkaproducer.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonRepository extends CrudRepository<Person, UUID> {
}
