package com.gs.backend_template.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FooController {

    @GetMapping(
            value = "/api/foo/{id}"
    )
    public ResponseEntity<String> getFoo(@PathVariable int id) {
        return ResponseEntity.ok("Get Foo " + id);
    }

    @PostMapping(
            value = "/api/foo"
    )
    public ResponseEntity<String> postFoo(@RequestBody String foo) {
        return ResponseEntity.status(201).body("Post Foo " + foo);
    }

    @PutMapping(
            value = "/api/foo/{id}"
    )
    public ResponseEntity<String> putFoo(@PathVariable int id, @RequestBody String foo) {
        return ResponseEntity.ok("Put Foo " + id + " " + foo);
    }

    @DeleteMapping(
            value = "/api/foo/{id}"
    )
    public ResponseEntity<String> deleteFoo(@PathVariable int id) {
        return ResponseEntity.ok("Delete Foo " + id);
    }
}
