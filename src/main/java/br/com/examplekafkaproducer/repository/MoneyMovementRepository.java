package br.com.examplekafkaproducer.repository;

import br.com.examplekafkaproducer.model.MoneyMovement;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface MoneyMovementRepository extends CrudRepository<MoneyMovement, UUID> {
}
