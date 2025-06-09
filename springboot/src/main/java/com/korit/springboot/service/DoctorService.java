package com.korit.springboot.service;

import com.korit.springboot.domain.dto.DoctorRegisterDto;
import com.korit.springboot.domain.entity.DepartmentEntity;
import com.korit.springboot.domain.entity.DoctorEntity;
import com.korit.springboot.repository.DepartmentRepository;
import com.korit.springboot.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DoctorService {

    private DoctorRepository doctorRepository;
    private DepartmentRepository departmentRepository;

    public void register(DoctorRegisterDto dto) {
        departmentRepository.findByDepartmentName(dto.getDepartmentName())
                .ifPresentOrElse(
                        departmentEntity -> {
                            //name을 찾았으면 save()
                            DoctorEntity entity = dto.toEntity(departmentEntity.getId());
                            doctorRepository.save(entity);
                        },
                        () ->{
                            //name이 없으면,
                            DepartmentEntity department = DepartmentEntity.builder()
                                    .departmentName(dto.getDepartmentName())
                                    .build();
                            DepartmentEntity departmentEntity = departmentRepository.save(department);
                            DoctorEntity entity = dto.toEntity(departmentEntity.getId());
                            doctorRepository.save(entity);
                        }
        );
//        departmentRepository.findByDepartmentName(dto.getDepartmentName())
//                .ifPresentOrElse(
//                        departmentEntity -> doctorRepository.save(dto.toEntity(departmentEntity.getId())),
//                        () -> doctorRepository.save(dto.toEntity(departmentRepository.save(DepartmentEntity.builder()
//                                    .departmentName(dto.getDepartmentName())
//                                    .build()).getId()))
//                );
    }
}
