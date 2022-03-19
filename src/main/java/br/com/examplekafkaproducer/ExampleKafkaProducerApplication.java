package br.com.examplekafkaproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ExampleKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleKafkaProducerApplication.class, args);
	}

}
