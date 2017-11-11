package com.example.demo.springjunit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * Hello World controller.
 */
@RestController
public class HomeController {


    @GetMapping(value = "/patient",  produces = APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity helloWorld() {
        return ResponseEntity.ok().body("Hello World");
    }
}
