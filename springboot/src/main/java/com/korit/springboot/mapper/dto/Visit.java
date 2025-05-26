package com.korit.springboot.mapper.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
*   Mybatis를 사용해서 데이터를 관리할 때 사용될 Entity 객체
*   모든 Mapper의 DTO는 DB의 테이블 구조와 동일하게 작성한다.
*
*
*/
@Builder
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Visit {
    private Integer visitId;
    private Integer patientId;
    private Integer doctorId;
    private Integer treatmentId;
    private LocalDateTime visitData;
    private Integer fee;
}
