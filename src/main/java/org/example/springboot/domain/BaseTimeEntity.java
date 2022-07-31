package org.example.springboot.domain;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // JPA entity들이 상속할때 필드들을 칼럼으로 인식한다.
@EntityListeners({AuditingEntityListener.class}) // Auditing 기능 포함
public class BaseTimeEntity {
    @CreatedDate // entity 생성 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate // 조회된 entity 값 변경 시간 자동 저장
    private LocalDateTime modifiedDate;
}
