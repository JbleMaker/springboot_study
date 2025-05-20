package com.korit.springboot.ioc;

import org.springframework.stereotype.Component;

@Component
public class 스마트폰 {

    private 배터리 b;

    public 스마트폰(배터리 b){
        this.b = b;
    }

    public void 전원켜기(){
        b.전류공급();
        System.out.println("배터리로부터 전류를 공급받아 전원을 켭니다.");
    }
}
