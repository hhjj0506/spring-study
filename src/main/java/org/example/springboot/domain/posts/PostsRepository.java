package org.example.springboot.domain.posts;
import javafx.geometry.Pos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// MyBatis의 DAO 같은 역할을 하는, DB Layer 접근자이다.
// 인터페이스로 생성 후 JpaRepository<Entity, PK 타입>을 넣어주면 기본적인 CRUD 메소드가 자동으로 생성된다
// Class와 Repository는 항상 같이 있어야한다
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
