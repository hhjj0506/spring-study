package org.example.springboot.domain.posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.springboot.domain.BaseTimeEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter // 클래스 내 모든 필드의 Getter 자동 생성 완전 편함 짱짱
@NoArgsConstructor // 생성자 자동 추가 (여기선 public Posts() {})
@Entity// DB의 테이블과 연결될 클래스를 칭한다. 클래스의 이름이 변환되어 테이블의 이름이 된다.
public class Posts extends BaseTimeEntity {

    @Id // 테이블의 PK가 된다
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙을 나타낸다.
    // GenerationType.IDENTITY 가 있어야 Auto Increment가 된다
    private Long id;

    @Column(length = 500, nullable = false) // 선언하여 칼럼의 옵션을 설정한다 (선언 안해도 클래스의 모든 필드는 칼럼이 되긴 함)
    // 문자열 기본이 VARCHAR(255)라서 여기서 사이즈를 늘렸다
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 클래스의 빌더 패턴 생성한다
    // 특이한 점은 Entity 클래스에서는 Setter를 절대 만들지 않는다.
    // 해당 클래스의 인스턴스 값들이 언제 어디서 변해야하는지 명확하게 구분할 수 없기 때문에
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
