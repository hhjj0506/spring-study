package org.example.springboot.web;
import lombok.RequiredArgsConstructor;
import org.example.springboot.config.auth.LoginUser;
import org.example.springboot.config.auth.dto.SessionUser;
import org.example.springboot.service.PostsService;
import org.example.springboot.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) { // 기존에 httpSession으로 가져오던 세션정보값이 개선되었다. 이제 @LoginUser만 사용하면 어느 컨트롤러에서든 세션정보 가져올수 있다
        // Model은 서버 템플릿 엔진에서 사용할 수 있는 객체 저장 가능
        // findAllDesc(), 즉 조회한 결과를 posts로 index에 전달한다
        model.addAttribute("posts", postsService.findAllDesc());
        //SessionUser user = (SessionUser) httpSession.getAttribute("user"); 로그인 성공시 세션에 SessionUser를 저장한다.
        if (user != null) { // 세션에 저장된 유저가 있을때, 즉 로그인이 되어 있는 상태일때만 유저네임을 등록한다.
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }

    @GetMapping("/ranking")
    public String ranking() {
        return "ranking";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }
}
