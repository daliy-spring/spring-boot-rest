package com.example.hello.controller;
import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

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

    @GetMapping(path = "/query-param")
    public String queryParam(@RequestParam("sort") String sortMethod) {
        return sortMethod;
    }

    @GetMapping(path ="/query-param2")
    public String queryParam2(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ) {
        return name + " " + email + " " + age;
    }
    @GetMapping(path = "/query-param-map")
    public String queryParamMap(@RequestParam Map<String, String> queryParam) {
        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach(entry -> {
            System.out.println(entry.getKey()) ;
            System.out.println(entry.getValue()) ;
            System.out.println("\n");

            sb.append(entry.getKey() + " = " + entry.getValue() + "\n");

        });
        return sb.toString();
    }

    //request param 어노테이션 넣지 않음 => 내부적으로 객체가 인자로 들어오면, query param을 매칭을 해서 넣어준다.
    @GetMapping(path ="/query-param3")
    public String queryParam3(
        UserRequest userRequest
    ) {
        return userRequest.toString();

    }
}


