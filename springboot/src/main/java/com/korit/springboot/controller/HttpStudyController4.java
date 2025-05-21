package com.korit.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/*
    * REST API(RESTful API)
    * 요청과 응답
    * https://m.blog.naver.com/codingbarbie/223233477242
    * https://hahahoho5915.tistory.com/54
    * 주소만을 보고 자원을 판단하기 위함
    *
 */

@RestController
public class HttpStudyController4 {

    @GetMapping("/api/study/http/get")
    public ResponseEntity<Map<String, Object>> get(){
//        Map.of("name","jongbo","age",35);
//        return new ResponseEntity<>(Map.of("name","jongbo","age",35), HttpStatus.BAD_REQUEST);
        return ResponseEntity.badRequest().body(Map.of("name","jongbo","age",35));
    }
}
