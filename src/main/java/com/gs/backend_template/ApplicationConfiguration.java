package com.gs.backend_template;

import com.gs.backend_template.database.FooRepository;
import com.gs.backend_template.database.H2FooRepository;
import com.gs.backend_template.service.FooService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPass;

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
        return new H2FooRepository(dbUrl, dbUser, dbPass);
    }
}
