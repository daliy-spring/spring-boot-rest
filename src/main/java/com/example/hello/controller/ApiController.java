package com.example.hello.controller;

import com.example.hello.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // 해당 클래스는 Rest api를 처리하는 controller
@RequestMapping("/api") // RequestMapping URI 를 지정해주는 어노테이션
public class ApiController {
    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot";
    }

    //content-type: text/plain;charset=UTF-8
    //Text를 리턴
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }


    //application/json
    // req -> object mapper -> object -> method -> object -> object mapper -> json -> response
    @PostMapping("/json")
    public User json(@RequestBody User user){
        return user;
    }

    // use ResponseEntity
    @PutMapping("/put")
    public ResponseEntity<User> put(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
