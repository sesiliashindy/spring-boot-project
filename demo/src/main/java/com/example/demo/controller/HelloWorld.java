package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("/hello")
public class HelloWorld {

    @GetMapping
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/hello2")
    public String hello2(){
        return "Hello 2 World";
    }

    @GetMapping("/sesil")
    public String helloName(){
        return "Hello Sesilia";
    }
}
