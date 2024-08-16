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
    public ResponseEntity<Foo> getFoo(@PathVariable int id) {
        return ResponseEntity.ok(fooService.getFoo(id));
    }

    @PostMapping(
            value = "/api/foo"
    )
    public ResponseEntity<Foo> postFoo(@RequestBody Foo foo) {
        return ResponseEntity.status(201).body(fooService.addFoo(foo));
    }

    @PutMapping(
            value = "/api/foo/{id}"
    )
    public ResponseEntity<Foo> putFoo(@PathVariable int id, @RequestBody Foo foo) {
        return ResponseEntity.ok(fooService.updateFoo(id, foo));
    }

    @DeleteMapping(
            value = "/api/foo/{id}"
    )
    public ResponseEntity<Foo> deleteFoo(@PathVariable int id) {
        return ResponseEntity.ok(fooService.deleteFoo(id));
    }
}
