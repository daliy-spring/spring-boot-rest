package com.example.hello;

import com.example.hello.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloApplicationTests {
/*
object-mapper는 Text 형태의 JSON 형태를 object로 만들어주고, object를 text 형태의 JSON으로 변경해준다.
 */
    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("-----------");
        // Text JSON -> Object
        // Object -> Text JSON

        // controller req json(text) -> object
        // response object -> json(text)
        var objectMapper = new ObjectMapper();

        //object -> text
        // object mapper는 get method를 활용한다.
        // 만약 내가 생성한 객체가 object mapper에서 활용된다면 get이라는 함수는 사용하면 x
        var user = new User("steve", 10, "1234-1234-1234");
        var text = objectMapper.writeValueAsString(user);

        System.out.println(text);

        // text -> object
        // object mapper는 디펄트 생성자가 있어야 한다.
        var objectUser= objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
    }

}
