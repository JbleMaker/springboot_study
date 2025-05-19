package com.korit.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/api/http")
public class HelloServlet extends HttpServlet {
    // 서블릿은 톰캣을 실행
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("");
    }
}