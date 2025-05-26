package com.korit.springboot.controller.clinic;

import com.korit.springboot.dto.clinic.VisitRegisterDto;
import com.korit.springboot.mapper.VisitMapper;
import com.korit.springboot.mapper.dto.Visit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
    "
        {
            "patientId" : 0,
            "doctorId" : 0,
            "treatmentId" : 0,
            "visitDate" : "0000-00-00 00:00:00",
            "fee" : 0
        }
    "
 */

@RestController
@AllArgsConstructor
public class VisitController {

    private VisitMapper visitMapper;

    @PostMapping("/api/clinic/visits")
    public ResponseEntity<?> register(@RequestBody VisitRegisterDto visitRegisterDto){
        System.out.println(visitRegisterDto);

        visitMapper.insert(visitRegisterDto.toEntity());

        return ResponseEntity.ok("응답");
    }
}
