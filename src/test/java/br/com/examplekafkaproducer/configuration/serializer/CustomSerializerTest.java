package br.com.examplekafkaproducer.configuration.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomSerializerTest {

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private CustomSerializer customSerializer;

    @Test
    public void shouldSerializeTheObjectToPublishToTheTopicSuccessfullyTest() {

    }

}
