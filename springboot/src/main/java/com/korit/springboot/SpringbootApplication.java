package com.korit.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {
    // 스프링부트는 프로젝트를 실행 => 톰캣을 실행시킴.
    // 프로젝트를 실행시켜야 톰캣이 실행됨.
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
