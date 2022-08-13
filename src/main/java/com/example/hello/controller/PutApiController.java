package com.example.hello.controller;


import com.example.hello.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutApiController {

    @PutMapping("/put/{userId}")
    public PutRequestDto put(@RequestBody PutRequestDto dto, @PathVariable Long userId){
        System.out.println(dto);
        System.out.println(userId);
        return dto;
    }
}
