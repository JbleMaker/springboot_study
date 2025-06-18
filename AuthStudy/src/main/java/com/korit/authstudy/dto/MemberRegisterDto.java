package com.korit.authstudy.dto;

import com.korit.authstudy.domain.entity.Member;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@RequiredArgsConstructor
public class MemberRegisterDto {
// 프론트엔드에서 들어오는 변수명 맞춰주기
// 마찬가지로 대문자로 작성할시 백엔드에서 대문자앞에 언더스코어 변환

    private String username;
    private String password;
    private String fullName;
    private String email;

    public Member toEntity(BCryptPasswordEncoder passwordEncoder){
    //toEntity = Dto를 Entity로 변환
        return Member.builder()
                // 프론트에서 들어오는 데이터값을 
                // 백엔트변수(Member)에 builder를 통해 대입
                .memberName(username)
                .password(passwordEncoder.encode(password))
                .name(fullName)
                .email(email)
                .build();
    }
}
