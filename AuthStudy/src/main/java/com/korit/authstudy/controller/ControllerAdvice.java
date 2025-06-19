package com.korit.authstudy.controller;

import com.korit.authstudy.exception.BearerValidException;
import io.jsonwebtoken.JwtException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {


    // Authen Exception 오류는 해당 컨트롤러에서 컨트롤
    // 예외관련처리는 모두 해당 컨트롤러에서 처리
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<?> unauthorized(AuthenticationException exception) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.getMessage());
        //401
    }

    @ExceptionHandler(BearerValidException.class)
    public ResponseEntity<?> isNotBearer(AuthenticationException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        //400
    }

    @ExceptionHandler(JwtException.class)
    public ResponseEntity<?> jwtError(JwtException exception){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
        //403
    }
}
