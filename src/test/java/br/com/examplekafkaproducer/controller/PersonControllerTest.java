package br.com.examplekafkaproducer.controller;

import br.com.examplekafkaproducer.AbstracIntegrationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

public class PersonControllerTest extends AbstracIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldSavePersonAndPostToTopicSuccessfullyTest() {

    }

}
