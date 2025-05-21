package com.korit.springboot.controller;

import com.korit.springboot.ioc.BeanStudy;
import com.korit.springboot.ioc.스마트폰;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IoCController {
    // 컨테이너?
    // 외부에서 객체를 생성하고, 결정해주는 것
    // springboot 자체에서 제어 -> 객체 생성 및 관리

    @Autowired      // 자동 객체 생성
    private 스마트폰 s;     // bean,
    private BeanStudy beanStudy;
    // 제어 흐름을 직접 제어하는 것이 아닌 외부에서 관리하는 것을 제어의 역전

    @GetMapping("/ioc")
    public String get(){
        s.전원켜기();
        return null;
    }

    @GetMapping("/ioc2")
    public String get2(){
        s.전원켜기();

        return null;
    }

}
