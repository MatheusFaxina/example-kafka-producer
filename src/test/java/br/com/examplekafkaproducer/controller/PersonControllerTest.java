package br.com.examplekafkaproducer.controller;

import br.com.examplekafkaproducer.AbstractIntegrationTest;
import br.com.examplekafkaproducer.model.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static br.com.examplekafkaproducer.utils.MockUtils.createPerson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PersonControllerTest extends AbstractIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldSavePersonAndPostToTopicSuccessfullyTest() throws Exception {
        final UUID personUuid = UUID.randomUUID();
        final Person person = createPerson(personUuid, "Name", "(44) 4 4444-4444", "email@gmail.com");

        mockMvc.perform(post("/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(person)))
                .andExpect(status().isOk())
                .andReturn();
    }

}
