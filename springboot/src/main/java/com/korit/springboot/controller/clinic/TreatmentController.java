package com.korit.springboot.controller.clinic;

import com.korit.springboot.domain.treatment.Treatment;
import com.korit.springboot.domain.treatment.TreatmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TreatmentController {
    private TreatmentRepository treatmentRepository;

    @PostMapping("/api/clinic/treatment")
    public ResponseEntity<?> register(@RequestBody Treatment treatment){
        treatmentRepository.save(treatment);
        return ResponseEntity.ok(true);
    }
}
