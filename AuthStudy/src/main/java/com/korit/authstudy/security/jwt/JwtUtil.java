package com.korit.authstudy.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
//https://jwtsecrets.com/

    private final Key KEY;
    //jwt를 만들고 푸는데 사용하는 키

    public JwtUtil(@Value("${jwt.secret}") String secret) {
        KEY = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public String generateAccessToken(String id) {
        JwtBuilder jwtBuilder = Jwts.builder(); // 토큰 생성에 필요한 정보를 입력하는 역할
        Date expiDate = new Date(new Date().getTime() + (1000L *60L*60L*2L*30L));
//        System.out.println(jwtBuilder.subject("AccessToken").id(id).expiration(expiDate).signWith(KEY).compact());
        return jwtBuilder.subject("AccessToken").id(id).expiration(expiDate).signWith(KEY).compact(); //클레임이라고 부름
        //암호화 시킨 토큰을 리턴
    }

    public boolean isBearer(String token) {
        if(token == null) {
            return false;
        }
        if(!token.startsWith("Bearer ")){
            return false;
        }
        return true;
    }

    public String removeBearer(String bearerToken) {
        return bearerToken.replaceFirst("Bearer ", "");
    }

    public Claims getClaims(String token) { // generateAccessToken를 원래 데이터로 풀어줌
        JwtParserBuilder jwtParserBuilder = Jwts.parser();
        jwtParserBuilder.setSigningKey(KEY);
        JwtParser jwtParser = jwtParserBuilder.build();
        return jwtParser.parseClaimsJws(token).getPayload();//암호화되어 있는 토큰을 풀어줌
    }
}
