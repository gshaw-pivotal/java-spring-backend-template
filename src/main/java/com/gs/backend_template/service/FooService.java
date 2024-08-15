package com.gs.backend_template.service;

import com.gs.backend_template.database.FooRepository;
import com.gs.backend_template.model.Foo;

public class FooService {

    private final FooRepository fooRepository;

    public FooService(FooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    public Foo addFoo(Foo foo) {
        return fooRepository.addFoo(foo);
    }

    public Foo deleteFoo(int id) {
        return fooRepository.deleteFoo(id);
    }

    public Foo updateFoo(int id, Foo foo) {
        return fooRepository.updateFoo(id, foo);
    }

    public Foo getFoo(int id) {
        return fooRepository.getFoo(id);
    }
}
