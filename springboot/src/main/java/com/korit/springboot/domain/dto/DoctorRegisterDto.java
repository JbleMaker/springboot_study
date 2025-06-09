package com.korit.springboot.domain.dto;

import com.korit.springboot.domain.entity.DoctorEntity;
import lombok.Data;

// swgger에서 보낼때
@Data
public class DoctorRegisterDto {
    private String doctorName;
    private String departmentName;

    public DoctorEntity toEntity(Integer departmentId){
        return DoctorEntity.builder()
                .doctorName(doctorName)
                .departmentId(departmentId)
                .build();
    }
}
