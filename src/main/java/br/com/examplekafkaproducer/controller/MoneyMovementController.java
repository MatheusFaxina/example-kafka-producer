package br.com.examplekafkaproducer.controller;

import br.com.examplekafkaproducer.model.MoneyMovement;
import br.com.examplekafkaproducer.service.interfaces.MoneyMovementService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/money-movements")
public class MoneyMovementController {

    private final MoneyMovementService moneyMovementService;

    public MoneyMovementController(final MoneyMovementService moneyMovementService) {
        this.moneyMovementService = moneyMovementService;
    }

    @PostMapping
    public void save(@RequestBody final MoneyMovement person) {
        moneyMovementService.save(person);
    }

}
