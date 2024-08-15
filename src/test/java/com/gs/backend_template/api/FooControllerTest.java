package com.gs.backend_template.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class FooControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private FooController fooController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(fooController).build();
    }

    @Test
    public void testGetFoo() throws Exception {
        String fooId = "1";
        MvcResult result = mockMvc.perform(get("/api/foo/" + fooId))
                .andExpect(status().is(200))
                .andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Get Foo " + fooId));
    }

    @Test
    public void testPostFoo() throws Exception {
        String foo = "foo-request";
        MvcResult result = mockMvc.perform(post("/api/foo").content(foo))
                .andExpect(status().is(201))
                .andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Post Foo " + foo));
    }

    @Test
    public void testPutFoo() throws Exception {
        String foo = "foo-request";
        String fooId = "1";
        MvcResult result = mockMvc.perform(put("/api/foo/" + fooId).content(foo))
                .andExpect(status().is(200))
                .andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Put Foo " + fooId + " " + foo));
    }

    @Test
    public void testDeleteFoo() throws Exception {
        String fooId = "1";
        MvcResult result = mockMvc.perform(delete("/api/foo/" + fooId))
                .andExpect(status().is(200))
                .andReturn();

        assertTrue(result.getResponse().getContentAsString().contains("Delete Foo " + fooId));
    }
}