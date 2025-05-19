package com.korit.springboot.controller;

// 요청 URL : /api/age 응답데이터 : { name : 김종보, age : 35}
// 요청 URL : /api/names 응답데이터 : ["일","이","삼"]
// 요청 URL : /api/students 응답데이터 : [{name : 김종보, age : 35},{name : JONGBO, age : 35},]

/*
    [
        {
            name: 김종보,
            age: 35,
            hobby: [축구, 농구]
        },
        {
            name: 김종보,
            age: 35,
            hobby: [축구, 농구]
        }
    ]
 */


import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class HttpStudyController2 {

    @GetMapping("/age")
    public Map<String, Object> getInfo(){
        Map<String, Object> info = new HashMap<>();
        info.put("name", "kim"); // key : value
        info.put("age", 35);

//        return info;
        return Map.of("name", "kim","age", 35);
    }

    @GetMapping("/names")
    public List<String> getName() {
//        List<String> names = new ArrayList<>();
//        names.add("일");
//        names.add("이");
//        names.add("삼");
//        return names;
        return List.of("일","이","삼");
    }

    @GetMapping("/names2")
    public String[] names2(){
        String[] names = {"1", "2", "3"};

        return names;
    }


    @GetMapping("/students")
    // [{name : 김종보, age : 35},{name : JONGBO, age : 35},]
    public List<Map<String, Object>> getStudents(){
        List<Map<String, Object>> students = new ArrayList<>();
//        Map<String, Object> student1 = new HashMap<>();
//        student1.put("name", "kim");
//        student1.put("age", 35);
//        Map<String, Object> student2 = new HashMap<>();
//        student2.put("name", "김");
//        student2.put("age", 35);

        Map<String, Object> student1 = new HashMap<>();
        Map<String, Object> student2 = new HashMap<>();
        student1.put("name", "kim");
        student1.put("age", 35);
        student2.put("name", "김");
        student2.put("age", 35);

//        students.add(student1);
//        students.add(student2);
//        return students;
//        return List.of(student1, student2);
        return List.of(
                Map.of("name", "kim", "age", 35),
                Map.of("name", "jong", "age", 34)
        );
    }

/*
    [
        {
            name: 김종보,
            age: 35,
            hobby: [축구, 농구]
        },
        {
            name: 김종보,
            age: 35,
            hobby: [축구, 농구]
        }
    ]
 */

    @GetMapping("/students2")
    public List<Map<String, Object>> getStudents2 (){
        List<Map<String, Object>> students = new ArrayList<>();
        Map<String,Object> student1 = new HashMap<>();
        Map<String,Object> student2 = new HashMap<>();

//        List<String> hobby1 = new ArrayList<>(List.of("농구", "축구"));
//        List<String> hobby2 = new ArrayList<>(List.of("낚시", "골프"));

//        hobby1.add("농구");
//        hobby1.add("축구");
//        hobby2.add("낚시");
//        hobby2.add("골프");

        student1.put("name","김종보");
        student1.put("age",35);
        student1.put("hobby",List.of("농구", "축구"));
//        student1.put("hobby",new ArrayList<>(List.of("농구", "축구")));
        student2.put("name","jongbo");
        student2.put("age",35);
        student2.put("hobby",new ArrayList<>(List.of("낚시", "골프")));

        students.add(student1);
        students.add(student2);
//        return List.of(
//                Map.of("name","김종보","age",35,"hobby",List.of("농구", "축구")),
//                Map.of("name","KIMJONGBO","age",35,"hobby",List.of("낚시", "골프"))
//        );
        return List.of(student1, student2);
//        return students;
    }

}
