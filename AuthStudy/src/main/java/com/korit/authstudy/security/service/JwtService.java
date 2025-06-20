package com.korit.authstudy.security.service;

import com.korit.authstudy.dto.LoginStatusDto;
import com.korit.authstudy.exception.BearerValidException;
import com.korit.authstudy.security.jwt.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {

    private final JwtUtil jwtUtil;
    public LoginStatusDto validAccessToken(String bearerToken) {

        if(!jwtUtil.isBearer(bearerToken)){
            // 해당 bearerToken인지 확인
            throw new BearerValidException();
        }
        String accessToken = jwtUtil.removeBearer(bearerToken); // accesstoken 문자열
        Claims claims = jwtUtil.getClaims(accessToken);
        Integer userId = Integer.parseInt(claims.getId());
        return LoginStatusDto.builder()
                .status("success")
                .isLogin(userId != null)
                .userId(userId)
                .build();
    }
}
