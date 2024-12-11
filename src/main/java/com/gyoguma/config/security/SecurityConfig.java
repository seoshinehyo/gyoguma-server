package com.gyoguma.config.security;//package _bit.gyoguma.config.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@EnableWebSecurity // Spring Security 설정 활성화 -> 우리가 직접 작성한 보안 설정이 Spring Security의 기본 설정보다 우선 적용
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { // SecurityFilterChain 정의
//        http
//                .authorizeHttpRequests((requests) -> requests // HTTP 요청에 대한 접근 제어를 설정
//                        // requestMatchers : 특정 URL 패턴에 대한 접근 권한을 설정
//                        .requestMatchers("/", "/home", "/signup", "/members/signup", "/css/**").permitAll() // 인증 없이 접근 가능한 경로를 지정
//                        .requestMatchers("/admin/**").hasRole("ADMIN") // 'ADMIN' 역할을 가진 사용자만 접근 가능하도록 제한
//                        .anyRequest().authenticated() // 그 외 모든 요청에 대해 인증을 요구
//                )
//                // 폼 기반 로그인 설정
//                .formLogin((form) -> form
//                        .loginPage("/login") // 커스텀 로그인 페이지를 /login 경로로 지정
//                        .defaultSuccessUrl("/home", true) // 로그인 성공 시 /home으로 리다이렉트
//                        .permitAll() // 로그인 페이지는 모든 사용자가 접근 가능
//                )
//                // 로그아웃 처리에 대한 설정
//                .logout((logout) -> logout
//                        .logoutUrl("/logout") // /logout 경로로 로그아웃을 처리
//                        .logoutSuccessUrl("/login?logout") // 로그아웃 성공 시 /login?logout으로 리다이렉트
//                        .permitAll()
//                )
//                // OAuth2 관련 설정
//                .oauth2Login(oauth2 -> oauth2
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/home", true)
//                        .permitAll()
//                );
//
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); // 비밀번호를 암호화하여 저장
//    }
//}
