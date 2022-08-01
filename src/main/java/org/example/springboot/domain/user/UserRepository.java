package org.example.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // 구글 로그인 중 받은 이메일을 통해 이미 사용된 이메일인지 확인한다.
}
