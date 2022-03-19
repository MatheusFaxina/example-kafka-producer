package br.com.examplekafkaproducer.controller;

import br.com.examplekafkaproducer.model.Person;
import br.com.examplekafkaproducer.service.interfaces.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void save(@RequestBody final Person person) {
        personService.save(person);
    }

}
