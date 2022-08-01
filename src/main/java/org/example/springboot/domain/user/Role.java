package org.example.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role { // 각 사용자의 권한을 관리하는 enum 클래스
    // spring security 권한 코드에서는 항상 ROLE_이 앞에 있어야 한다
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
