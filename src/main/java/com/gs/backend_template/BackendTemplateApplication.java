package com.gs.backend_template;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gs.backend_template.model.Foo;
import com.gs.backend_template.service.FooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class BackendTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendTemplateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(FooService service) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Foo>> typeReference = new TypeReference<>() {};

			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/foo.json");
			try {
				List<Foo> foos = mapper.readValue(inputStream, typeReference);
				service.loadFoos(foos);
			} catch (Exception e) {
				System.out.println("Unable to load and save foo: " + e.getMessage());
			}
		};
	}
}
