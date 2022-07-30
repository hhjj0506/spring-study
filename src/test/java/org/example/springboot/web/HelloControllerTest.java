package org.example.springboot.web;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class) // Junit이 아닌 SpringRunner로 실행시킨다
@WebMvcTest(controllers = HelloController.class) // Controller 관련만 사용할 수 있다
public class HelloControllerTest {
    @Autowired // Spring이 관린하는 bean을 주입받는다
    private MockMvc mvc; //Spring MVC 테스트의 시작점, HTTP GET, POST 등 웹 API를 테스트할 때 사용한다

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) //isOK의 상태는 200
                .andExpect(content().string(hello)); //해당 주소로 request를 보냈을 때 받아오는 콘텐츠를 확인한다.
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        // param 값은 String만 허용되기 때문에 숫자는 String.valueOf 같은 방법으로 변경해줘야한다
        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
