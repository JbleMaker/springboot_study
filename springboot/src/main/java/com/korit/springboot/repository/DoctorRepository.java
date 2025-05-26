package com.korit.springboot.repository;

import com.korit.springboot.domain.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Integer> {
}
