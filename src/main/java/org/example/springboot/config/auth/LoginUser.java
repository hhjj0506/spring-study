package org.example.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // annotation 생성 위치 저장. 메소드의 param으로 선언된 객체만 사용 가능
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser { // 이 파일을 anno. 클래스로 지정한다.
}
