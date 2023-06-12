package com.teach.me.filter;

import com.teach.me.models.SimpleUser;
import com.teach.me.services.UserService;
import com.teach.me.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    private static final String AUTHORIZATION_STRING = "Authorization";
    private static final String BEARER_STRING = "Bearer ";
    private static final int BEARER_STRING_LENGTH = 7;
    private final JwtUtil jwtUtil;
    private final UserService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader(AUTHORIZATION_STRING);

        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER_STRING)) {
            String jwt = authorizationHeader.substring(BEARER_STRING_LENGTH);
            String username = jwtUtil.extractUsername(jwt);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                SimpleUser simpleUser = userDetailsService.getUserByUsername(username);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(simpleUser, null, null);
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }

        chain.doFilter(request, response);
    }

}