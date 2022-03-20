package br.com.examplekafkaproducer.configuration.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Objects;

@Configuration
public class CustomSerializer implements Serializer {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(final String s, final Object o) {
        try {
            if (Objects.isNull(o)){
                return null;
            }

            return objectMapper.writeValueAsBytes(o);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing MessageDto to byte[]");
        }
    }

    @Override
    public void configure(final Map configs, final boolean isKey) {
    }

    @Override
    public void close() {
    }

}
