package com.gs.backend_template.api;

import com.gs.backend_template.model.Foo;
import com.gs.backend_template.service.FooService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FooController {

    private final FooService fooService;

    public FooController(FooService fooService) {
        this.fooService = fooService;
    }

    @GetMapping(
            value = "/api/foo/{id}"
    )
    public ResponseEntity<String> getFoo(@PathVariable int id) {
        fooService.getFoo(id);
        return ResponseEntity.ok("Get Foo " + id);
    }

    @PostMapping(
            value = "/api/foo"
    )
    public ResponseEntity<String> postFoo(@RequestBody Foo foo) {
        fooService.addFoo(foo);
        return ResponseEntity.status(201).body("Post Foo " + foo);
    }

    @PutMapping(
            value = "/api/foo/{id}"
    )
    public ResponseEntity<String> putFoo(@PathVariable int id, @RequestBody Foo foo) {
        fooService.updateFoo(id, foo);
        return ResponseEntity.ok("Put Foo " + id + " " + foo);
    }

    @DeleteMapping(
            value = "/api/foo/{id}"
    )
    public ResponseEntity<String> deleteFoo(@PathVariable int id) {
        fooService.deleteFoo(id);
        return ResponseEntity.ok("Delete Foo " + id);
    }
}
