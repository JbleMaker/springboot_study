package com.korit.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController         // RestController << ResponseBody 안붙여도됨.
@RequestMapping("/api")
public class HttpStudyController {
    // springboot mvc (servlet / springboot)

    @GetMapping("/http")
//    @ResponseBody   // data response
    public String getStrig(){
        return "";
    }
    
    @GetMapping("/name")
    public String getName(){
        return "김종보";
    }
}
