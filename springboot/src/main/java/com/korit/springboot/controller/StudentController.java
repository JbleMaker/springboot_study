package com.korit.springboot.controller;

import com.korit.springboot.domain.entity.StudentEntity;
import com.korit.springboot.service.StudentService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/js/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody StudentEntity student) {

        return ResponseEntity.created(null).body(studentService.register(student));
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(studentService.getAll());
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<?> remove(@PathVariable Integer studentId){
        return ResponseEntity.ok(studentService.remove(studentId));
    }
}
