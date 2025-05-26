package com.korit.springboot.mapper;

import com.korit.springboot.mapper.dto.Visit;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface VisitMapper {
    int insert(Visit visit);


}


