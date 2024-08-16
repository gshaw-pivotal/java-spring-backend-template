package com.gs.backend_template.database;

import com.gs.backend_template.model.Foo;

import java.util.HashMap;
import java.util.Map;

public class InMemoryFooRepository implements FooRepository {

    int nextId = 1;

    Map<Integer, Foo> foos = new HashMap<>();

    @Override
    public Foo addFoo(Foo foo) {
        foo.setId(nextId);
        foos.put(nextId, foo);
        nextId++;
        return foo;
    }

    @Override
    public Foo deleteFoo(int id) {
        return foos.remove(id);
    }

    @Override
    public Foo updateFoo(int id, Foo foo) {
        foos.put(id, foo);
        return foo;
    }

    @Override
    public Foo getFoo(int id) {
        return foos.get(id);
    }
}
