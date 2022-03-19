package br.com.examplekafkaproducer.controller;

import br.com.examplekafkaproducer.AbstractIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public class MoneyMovementControllerTest extends AbstractIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldSaveMoneyMovementAndPostToTopicSuccessfullyTest() {

    }

}
