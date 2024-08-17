package com.gs.backend_template;

import com.gs.backend_template.database.FooRepository;
import com.gs.backend_template.database.H2FooRepository;
import com.gs.backend_template.service.FooService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public FooService fooService(FooRepository fooRepository) {
        return new FooService(fooRepository);
    }

//    @Bean
//    public FooRepository fooRepository() {
//        return new com.gs.backend_template.database.InMemoryFooRepository();
//    }

    @Bean
    public FooRepository fooRepository() {
        return new H2FooRepository();
    }
}
