package com.korit.authstudy.controller;

import com.korit.authstudy.dto.MemberRegisterDto;
import com.korit.authstudy.service.MembersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j //loging 확인용 어노테이션
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MembersController {
    // Controller > Dto > entity > Service > Repository 
    // Controller => 프론트에서 들어오는 데이터 관리
    // Dto => 프론트에서 들어오는 데이터 가공후 entity에 전달
    // entity => 데이터베이스에 들어갈 컬럼명과 같도록 셋팅
    // Service => jpaRepository를 사용해서 CRUD를 수행
    // => Dto에서 가공된 데이터를 Service측에서 CRUD

    private final MembersService membersService;

    @PostMapping
    public ResponseEntity<?> registerMember(@RequestBody MemberRegisterDto dto){
        log.info("DTO{}", dto);

        return ResponseEntity.ok(membersService.register(dto));
        //memberservice.regitser(dto)를 응답으로 리턴
    }
}
