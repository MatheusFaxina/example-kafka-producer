package br.com.examplekafkaproducer.controller;

import br.com.examplekafkaproducer.AbstractIntegrationTest;
import br.com.examplekafkaproducer.model.MoneyMovement;
import br.com.examplekafkaproducer.model.TypeMovement;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static br.com.examplekafkaproducer.utils.MockUtils.createMoneyMovement;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MoneyMovementControllerTest extends AbstractIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldSaveMoneyMovementAndPostToTopicSuccessfullyTest() throws Exception {
        final UUID uuid = UUID.fromString("064596d4-81d7-463b-8f44-1865a9314c19");
        final UUID personUuid = UUID.fromString("0b3ccf17-3615-4b46-aea2-f5e6fd458655");
        final MoneyMovement moneyMovement = createMoneyMovement(uuid, personUuid, TypeMovement.DEPOSIT, "10");

        mockMvc.perform(post("/money-movements")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(moneyMovement)))
                .andExpect(status().isOk())
                .andReturn();
    }

}
