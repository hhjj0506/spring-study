package org.example.springboot.web;
import org.example.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //controller that returns JSON
public class HelloController {
    @GetMapping("/hello") //formerly RequestMapping -> runs GET Method
    public String hello() { // if request comes in for /hello, return "hello"
        return "hello";
    }

    @GetMapping("/hello/dto")
    // @RequestParam은 외부에서 받아온 파라미터를 가져온다. 상대방에서 넘긴 "name"을 여기 String name에 저장한다.
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
