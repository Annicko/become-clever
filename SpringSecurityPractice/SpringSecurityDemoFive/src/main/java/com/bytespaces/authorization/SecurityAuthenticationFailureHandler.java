package com.bytespaces.authorization;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SecurityAuthenticationFailureHandler extends ExceptionMappingAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        System.out.println("登入失败，进入到 onAuthenticationFailure ");
        if (request.getHeader("accept").contains("application/json")) {
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(401);
            PrintWriter out = response.getWriter();
            // 输出失败的原因
            out.write("{\"error_code\":\"401\", \"name\":\"" + e.getClass() + "\", \"message\":\"" + e.getMessage() + "\"}");
        } else {
            super.onAuthenticationFailure(request, response, e);
        }
    }
}