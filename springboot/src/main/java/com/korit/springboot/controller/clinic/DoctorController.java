package com.korit.springboot.controller.clinic;

import com.korit.springboot.domain.dto.DoctorRegisterDto;
import com.korit.springboot.service.DoctorService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@AllArgsConstructor
public class DoctorController {
    /*
    {
        doctorName :
        departmentName:
    }
    * */
    private DoctorService doctorService;

    @PostMapping("/api/clinic/doctors")
    public ResponseEntity<?> register(@RequestBody DoctorRegisterDto dto){
        doctorService.register(dto);
        return ResponseEntity.ok(null);
    }
}
