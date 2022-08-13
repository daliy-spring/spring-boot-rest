package com.example.hello.controller;
import com.example.hello.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostApiControlelr {
    @PostMapping("/post")
    public  void post(@RequestBody Map<String, Object> requestDate) {
        requestDate.forEach((key, value) -> {
            System.out.println("key :" + key);
            System.out.println("value :" + value);
        });
    }

    @PostMapping("/post2")
    public  void post2(@RequestBody PostRequestDto dto) {
        System.out.println(dto.toString());
    }
}
