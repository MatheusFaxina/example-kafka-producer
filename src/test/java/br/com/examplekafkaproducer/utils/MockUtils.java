package br.com.examplekafkaproducer.utils;

import br.com.examplekafkaproducer.model.MoneyMovement;
import br.com.examplekafkaproducer.model.Person;
import br.com.examplekafkaproducer.model.TypeMovement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MockUtils {

    public static Person createPerson(final UUID uuid, final String name, final String phone, final String email) {
        return Person.builder()
                .uuid(uuid)
                .name(name)
                .phone(phone)
                .email(email)
                .build();
    }

    public static MoneyMovement createMoneyMovement(final UUID uuid, final UUID personUuid, final TypeMovement typeMovement, final String value) {
        return MoneyMovement.builder()
                .uuid(uuid)
                .personUuid(personUuid)
                .type(typeMovement)
                .value(value)
                .build();
    }

}
