package com.korit.authstudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        // CORS ORIGIN 전역설정 셋팅
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 요청을 보내는 쪽의 도메인(사이트 주소)
        corsConfiguration.addAllowedOriginPattern(CorsConfiguration.ALL);
        // 요청을 보내는 쪽에서 Requset, Response HEADER 정보에 대한 제약
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL);
        // 요청을 보내는 쪽의 메소드(GET, POST, PUT, DELETE, OPTION등) 
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL);
        
        // 모든 URL에 셋팅
        
        //요청 URL(/api/users)에 대한 CORS 설정 적용을 위해 객체 생성
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfiguration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.cors(Customizer.withDefaults());   // 위에서 만든 cors설정 security에 적용
        http.csrf(csrf -> csrf.disable());      //csrf 토큰x => jwt 토큰으로 인증 // SSR REST API방식에서 비활성화
        http.formLogin(formLogin -> formLogin.disable());   //SSR 로그인 방식 비활성화
        http.httpBasic(httpBasic -> httpBasic.disable());   //HTTP protocal 기본로그인 방식 비활성화
        http.logout(logout -> logout.disable()); // SSR 로그아웃 방식 비활성

        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());  // 모든 요청 허가
        // HttpSecurity 객체에 설정한 모든 정보를 기반으로 build하여 SecurityFilterChain 객체 생성
        return http.build();
    }
}

