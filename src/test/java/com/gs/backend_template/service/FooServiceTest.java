package com.gs.backend_template.service;

import com.gs.backend_template.database.FooRepository;
import com.gs.backend_template.model.Foo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class FooServiceTest {

    @Mock
    private FooRepository fooRepository;

    @InjectMocks
    private FooService fooService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddFoo() {
        Foo inputFoo = Foo.builder().desc("Foo Desc").build();
        Foo repoFoo = Foo.builder().id(1).desc("Foo Desc").build();

        Mockito.when(fooRepository.addFoo(inputFoo)).thenReturn(repoFoo);

        Foo result = fooService.addFoo(inputFoo);

        assertEquals(result.getId(), repoFoo.getId());
        assertEquals(result.getDesc(), inputFoo.getDesc());
    }

    @Test
    public void testUpdateFoo() {
        int id = 1;
        Foo inputFoo = Foo.builder().id(id).desc("Foo Desc").build();
        Foo repoFoo = Foo.builder().id(id).desc("Foo Desc").build();

        Mockito.when(fooRepository.updateFoo(id, inputFoo)).thenReturn(repoFoo);

        Foo result = fooService.updateFoo(id, inputFoo);

        assertEquals(result.getId(), repoFoo.getId());
        assertEquals(result.getDesc(), inputFoo.getDesc());
    }

    @Test
    public void testDeleteFoo() {
        int id = 1;
        Foo repoFoo = Foo.builder().id(id).desc("Foo Desc").build();

        Mockito.when(fooRepository.deleteFoo(id)).thenReturn(repoFoo);

        Foo result = fooService.deleteFoo(id);

        assertEquals(result.getId(), repoFoo.getId());
        assertEquals(result.getDesc(), repoFoo.getDesc());
    }

    @Test
    public void testGetFoo() {
        int id = 1;
        Foo repoFoo = Foo.builder().id(id).desc("Foo Desc").build();

        Mockito.when(fooRepository.getFoo(id)).thenReturn(repoFoo);

        Foo result = fooService.getFoo(id);

        assertEquals(result.getId(), repoFoo.getId());
        assertEquals(result.getDesc(), repoFoo.getDesc());
    }
}