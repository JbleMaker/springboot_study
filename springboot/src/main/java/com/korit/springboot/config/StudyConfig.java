package com.korit.springboot.config;

import com.korit.springboot.ioc.BeanStudy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudyConfig {

    @Bean
    // 다른 외부의 라이브러리를 사용하고자 할때
    // 직접 Bean으로 등록하기 위해 사용.
    public BeanStudy beanStudy(){
        System.out.println("bean 생성");
        return new BeanStudy();
    }

}
