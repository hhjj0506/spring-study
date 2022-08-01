package org.example.springboot.config.auth;

import lombok.RequiredArgsConstructor;
import org.example.springboot.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // spring security 설정들 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable() // h2-console 사용 위한 화면들 비활성화
                .and().authorizeRequests() // URL별 관리 권한 설정의 시작점. 이게 있어야 antMatchers 사용 가능
                .antMatchers("/", "/css/**", "/images/**",
                        "js/**", "/h2-console/**").permitAll().antMatchers("/api/v1/**")
                .hasRole(Role.USER.name()) // permitAll() 이전 선언된 URL들은 전체 열람 권한을 부여했고, /api/v1/**는 USER 권한을 가진 사람만 가능하도록 설정
                .anyRequest().authenticated() // 앞에서 설정된 값들 이외 모든 URL들은 authenticated, 즉 인증, 로그인된 사용자만 권한 부여
                .and().logout().logoutSuccessUrl("/") // 로그아웃 성공시 "/"로 이동
                .and().oauth2Login() // OAuth 2 로그인 기능 설정 진입점
                .userInfoEndpoint() // 로그인 성공 이후 사용자 정보를 가져올때의 설정 담당
                .userService(customOAuth2UserService); // 로그인 성송시 후속 조치를 진행할 UserService 인터페이스의 구현체 등록
                // 리소스(소셜) 서버에서 사용자 정보를 가져온 상태에서 추가로 하고자 하는 기능 명시 가능

    }
}
