package com.gs.backend_template.database;

import com.gs.backend_template.model.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryFooRepositoryTest {

    private FooRepository fooRepository;

    @BeforeEach
    public void setUp() {
        fooRepository = new InMemoryFooRepository();
    }

    @Test
    public void testCRUDOperations() {
        assertNull(fooRepository.getFoo(1));
        assertNull(fooRepository.deleteFoo(1));

        Foo foo = Foo.builder().desc("Foo Desc").build();

        Foo addResult = fooRepository.addFoo(foo);

        assertEquals(addResult.getId(), 1);
        assertEquals(addResult.getDesc(), foo.getDesc());

        Foo getResult = fooRepository.getFoo(1);
        assertEquals(getResult.getId(), 1);
        assertEquals(getResult.getDesc(), foo.getDesc());

        Foo newFoo = Foo.builder().id(1).desc("A new desc").build();

        Foo updateResult = fooRepository.updateFoo(1, newFoo);

        assertEquals(updateResult.getId(), 1);
        assertEquals(updateResult.getDesc(), newFoo.getDesc());

        getResult = fooRepository.getFoo(1);
        assertEquals(getResult.getId(), 1);
        assertEquals(getResult.getDesc(), newFoo.getDesc());

        Foo deleteResult = fooRepository.deleteFoo(1);
        assertEquals(deleteResult.getId(), 1);
        assertEquals(deleteResult.getDesc(), newFoo.getDesc());

        assertNull(fooRepository.getFoo(1));
    }
}