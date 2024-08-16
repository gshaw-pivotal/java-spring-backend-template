package com.gs.backend_template.api;

import com.gs.backend_template.model.Foo;
import com.gs.backend_template.service.FooService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class FooControllerTest {

    private MockMvc mockMvc;

    @Mock
    private FooService fooService;

    @InjectMocks
    private FooController fooController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(fooController).build();
    }

    @Test
    public void testGetFoo() throws Exception {
        int fooId = 1;
        Foo returnedFoo = Foo.builder().id(fooId).desc("").build();

        Mockito.when(fooService.getFoo(fooId)).thenReturn(returnedFoo);

        MvcResult result = mockMvc.perform(get("/api/foo/" + fooId))
                .andExpect(status().is(200))
                .andReturn();

        assertEquals("{\"id\":1,\"desc\":\"\"}", result.getResponse().getContentAsString());

        Mockito.verify(fooService).getFoo(fooId);
    }

    @Test
    public void testPostFoo() throws Exception {
        String fooDesc = "foo-request";
        Foo foo = Foo.builder().desc(fooDesc).build();
        Foo serviceFoo = Foo.builder().id(1).desc(fooDesc).build();

        Mockito.when(fooService.addFoo(foo)).thenReturn(serviceFoo);

        MvcResult result = mockMvc.perform(post("/api/foo")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"desc\":  \"" + fooDesc + "\"}"))
                .andExpect(status().is(201))
                .andReturn();

        assertEquals("{\"id\":1,\"desc\":\"" + fooDesc + "\"}", result.getResponse().getContentAsString());

        Mockito.verify(fooService).addFoo(foo);
    }

    @Test
    public void testPutFoo() throws Exception {
        String fooDesc = "foo-request";
        int fooId = 1;

        Foo foo = Foo.builder().id(fooId).desc(fooDesc).build();
        Foo serviceFoo = Foo.builder().id(fooId).desc(fooDesc).build();

        Mockito.when(fooService.updateFoo(fooId, foo)).thenReturn(serviceFoo);

        MvcResult result = mockMvc.perform(put("/api/foo/" + fooId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\": " + fooId + ", \"desc\":  \"" + fooDesc + "\"}"))
                .andExpect(status().is(200))
                .andReturn();

        assertEquals("{\"id\":1,\"desc\":\"" + fooDesc + "\"}", result.getResponse().getContentAsString());

        Mockito.verify(fooService).updateFoo(fooId, foo);
    }

    @Test
    public void testDeleteFoo() throws Exception {
        int fooId = 1;
        String fooDesc = "foo-delete";

        Mockito.when(fooService.deleteFoo(fooId)).thenReturn(Foo.builder().id(fooId).desc(fooDesc).build());

        MvcResult result = mockMvc.perform(delete("/api/foo/" + fooId))
                .andExpect(status().is(200))
                .andReturn();

        assertEquals("{\"id\":1,\"desc\":\"" + fooDesc + "\"}", result.getResponse().getContentAsString());

        Mockito.verify(fooService).deleteFoo(fooId);
    }
}