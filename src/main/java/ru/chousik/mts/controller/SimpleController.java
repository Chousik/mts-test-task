package ru.chousik.mts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/simple-case")
    public ResponseEntity<String> simpleCase(){
        return ResponseEntity.ok()
                .body("booo");
    }

    @GetMapping("with-custom-foo")
    public ResponseEntity<String> withCustomFoo(){
        return ResponseEntity.ok()
                .header("Foo", "neBar")
                .body("booo");
    }
}
