package com.example.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 해당 클래스는 Rest api를 처리하는 controller
@RequestMapping("/api") // RequestMapping URI 를 지정해주는 어노테이션
public class ApiController {
    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot";
    }
}
