package com.korit.authstudy.filter;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StudyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("전처리");
        filterChain.doFilter(servletRequest,servletResponse);
        // dofilter -> 다음 필터를 호출하는 역할
        // 전처리  ==> dofilter ==> 후처리
        System.out.println("후처리");
    }
}
