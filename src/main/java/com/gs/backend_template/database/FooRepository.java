package com.gs.backend_template.database;

import com.gs.backend_template.model.Foo;

public interface FooRepository {

    Foo addFoo(Foo foo);

    Foo deleteFoo(int id);

    Foo updateFoo(int id, Foo foo);

    Foo getFoo(int id);
}
