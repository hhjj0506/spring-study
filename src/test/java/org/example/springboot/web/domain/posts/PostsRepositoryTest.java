package org.example.springboot.web.domain.posts;
import org.example.springboot.domain.posts.Posts;
import org.example.springboot.domain.posts.PostsRepository;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After // JUnit에서 단위 테스트가 끝날 때마다 수행되는 메소드 지정
    // DB안에 데이터가 남아있을 수 있어 다시 테스트 진행 전 모두 지운다
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void findAll() {
        //given
        String title = "게시글";
        String content = "본문";

        // 테이블에 insert / update 쿼리를 실행한다.
        // id 값이 존재하면 update, 아니면 insert
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("hhjj0506@gmail.com")
                .build());

        //when
        // 테이블의 모든 데이터를 조회하여 List에 저장
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
