package com.teach.me.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        Map<String, String> error = new HashMap<>();
        error.put("status", HttpStatus.UNAUTHORIZED.getReasonPhrase());
        error.put("message", authException.getMessage() != null
                ? authException.getMessage()
                : "Full authentication is required to access this resource");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        response.getWriter().write((new ObjectMapper()).writeValueAsString(error));
    }
}
