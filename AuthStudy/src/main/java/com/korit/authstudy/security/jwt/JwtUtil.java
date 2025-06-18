package com.korit.authstudy.security.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
//https://jwtsecrets.com/

    private final Key KEY;

    public JwtUtil(@Value("${jwt.secret}") String secret) {
        KEY = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public String generateAccessToken(String id) {
        JwtBuilder jwtBuilder = Jwts.builder(); // 토큰 생성에 필요한 정보를 입력하는 역할
        Date expiDate = new Date(new Date().getTime() + (1000L *60L*60L*2L*30L));
        System.out.println(jwtBuilder.subject("AccessToken").id(id).expiration(expiDate).signWith(KEY).compact());
        return jwtBuilder.subject("AccessToken").id(id).expiration(expiDate).signWith(KEY).compact();
    }
}
