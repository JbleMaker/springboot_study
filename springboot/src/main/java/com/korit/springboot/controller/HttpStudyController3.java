package com.korit.springboot.controller;

import com.korit.springboot.dto.Address;
import com.korit.springboot.dto.PostData;
import com.korit.springboot.dto.Student;
import com.korit.springboot.dto.Students;
import com.korit.springboot.dto.param.SearchStudyDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class HttpStudyController3 {

    /*
        get : 해당 주소에 값을 입력한다.
        파라미터를 통해 값을 입력한다.
        파라미터는 주소의 '?' 뒤에 따라오는 key, value값을 의미한다.
        http://localhost:8080/api/name?name=sss&age=25
        => 여러개의 데이터를 요청시 '&'로 구분
     */
    @GetMapping("/study/get")
    public String get(
            @RequestParam String name,
            @RequestParam Integer age
    ){
        return "get 요청입니다.";
    }

    /*
    post : 가능한 json으로 값을 입력한다.
    "{
        "key1" : "value1",
        "key2" : "value2",
        "key3" : {
            key4 : value3.
            key5 : ["a", "b", "c"]
        }
    }"
     */
    @PostMapping("/study/post")
    public String post(
            @RequestBody Map<String, Object> data
    ){
        System.out.println(data);
        System.out.println(data.get("age"));
        System.out.println(data.get("address"));    // Object로 업캐스팅
        Object data2 = data.get("address");
        Map<String, Object> map = (Map<String, Object>) data2;

        Object data3 = map.get("address4");
        List<String> list = (List<String>) data3;

        System.out.println(data3);
        System.out.println(list);
        System.out.println(((Map<String,Object>)data.get("address")).get("address4"));      // 다운캐스팅
        return "post 요청입니다.";
    }

    @PostMapping("/study/post2")
    public String post2(
            @RequestBody PostData postData
    ){
        System.out.println(postData.getAddress());
        System.out.println(postData.getName());
        Address address = postData.getAddress();
        System.out.println(address.getAddress1() + "\n" + address.getAddress2() + "\n" + address.getAddress3() + "\n" + address.getAddress4());
        List<String> detail = address.getAddress4();
        System.out.println(detail.get(0));
        System.out.println(detail.get(1));
        return "POST Response2";
    }
    /*
        Class Student
        get요청
        /api/students
        응답 [{Student객체1},{Student객체2},{Student객체3}]
        post요청
        /api/students
        응답 {status:"성공", data: {Studnet객체}}
     */

    @GetMapping("/study/students")
    public List<Student> getStudents(SearchStudyDto searchStudyDto){
//        List<Student> students = List.of(
//                new Student("김종보", 35),
//                new Student("이종보", 34),
//                new Student("사종보", 33),
//                new Student("산종보", 32),
//                new Student("리종보", 34)
//        );

        List<Student> students = new ArrayList<>();

        Random random = new Random();
        int startCode = 0xAC00;     // 가
        int endCode = 0xD7A3;       // 힣

        for(int i = 0; i < 1000; i++){
            StringBuilder builder = new StringBuilder();
            builder.append((char) (startCode + random.nextInt(endCode - startCode +1)));
            builder.append((char) (startCode + random.nextInt(endCode - startCode +1)));
            builder.append((char) (startCode + random.nextInt(endCode - startCode +1)));
            students.add(new Student(builder.toString(), random.nextInt(100)+1));
        }

        if(searchStudyDto.getPage() > 1){
            searchStudyDto.setPage(1);
        }

        /*
            page = 1 -> 0 ~ 9
            page = 2 -> 10 ~ 9
            page = 3 -> 20 ~ 19
         */
        List<Student> foundStudents = students;
        if(searchStudyDto.getSearchValue() != null && !searchStudyDto.getSearchValue().isBlank()){
            foundStudents = students.stream().filter(s -> s.getName().contains(searchStudyDto.getSearchValue())).collect(Collectors.toList());
        }

        int startIndex = (searchStudyDto.getPage() - 1) * searchStudyDto.getCount();
        List<Student> newStudents = new ArrayList<>();

        for(int i = startIndex; i < (foundStudents.size() < searchStudyDto.getCount() ? foundStudents.size() : searchStudyDto.getCount()); i++){
            try {
                newStudents.add(foundStudents.get(startIndex + i));
            } catch (Exception e){
                System.out.println(e);
                break;
            }
        }

        return newStudents;
    }

    @PostMapping("/study/students")
    public Map<String, Object> postStudents(
            @RequestBody Students students
    ) {
        System.out.println(students.getStudents());
        System.out.println(students);
        return Map.of("status","성공","data", students);
    }

    /*
    put : json으로 값을 입력한다.
     */
    @PutMapping("/study/put")
    public String put(){
        return "put response";
    }


    /*
    delete : 경로에 값을 입력한다.
    /api/study/delete/10
     */
    @DeleteMapping("/study/delete/{category}/{id}")
    public String delete(
            @PathVariable Long id,
            @PathVariable String category
    ){
        return "delete response";
    }
}
