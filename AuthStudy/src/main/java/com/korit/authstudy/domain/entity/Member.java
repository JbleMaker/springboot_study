package com.korit.authstudy.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="members_tb")
public class Member {
// 데이터베이스와 테이블명,컬럼명 동일하게 맞춰주기

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement set
    @Column(name="members_id")
    private Integer id;

    private String memberName;
    //대문자로 작성시 백엔드에서 언더스코어로 변환
    private String password;
    private String name;
    private String email;
}
