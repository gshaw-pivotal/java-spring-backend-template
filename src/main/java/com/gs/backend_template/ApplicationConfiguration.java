package com.gs.backend_template;

import com.gs.backend_template.database.FooRepository;
import com.gs.backend_template.model.Foo;
import com.gs.backend_template.service.FooService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public FooService fooService(FooRepository fooRepository) {
        return new FooService(fooRepository);
    }

    @Bean
    public FooRepository fooRepository() {
        return new FooRepository() {
            @Override
            public Foo addFoo(Foo foo) {
                return null;
            }

            @Override
            public Foo deleteFoo(int id) {
                return null;
            }

            @Override
            public Foo updateFoo(int id, Foo foo) {
                return null;
            }

            @Override
            public Foo getFoo(int id) {
                return null;
            }
        };
    }
}
