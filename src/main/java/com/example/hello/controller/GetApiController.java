package com.example.hello.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path="/hello")
    public String getHello() {
        return "get hello";
    }

    // get post put delete 전부 동작하기때문에 아래처럼 사용
    @RequestMapping(path="/hi", method = RequestMethod.GET)
    public String hi(){
        return "get hi";
    }

    // http://localhost:9090/api/get/path-variable/{name}
    @GetMapping("/path-variable/{name}")
    public String pathVariable( @PathVariable String name){
        return "안녕하세요 " + name +  " 님";
    }

    // http://localhost:9090/api/get/path-variable/{name}
    @GetMapping("/path-variable2/{name}")
    public String pathVariable2( @PathVariable("name") String pathName){
        return "안녕하세요 " + pathName +  " 님";
    }

    @GetMapping("/query-param")
    public String queryParam(@RequestParam("sort") String sortMethod) {
        return sortMethod;
    }
}


