package com.teach.me.controllers;

import com.teach.me.config.CustomAuthenticationManager;
import com.teach.me.models.dtos.AuthenticationRequestPayload;
import com.teach.me.models.dtos.AuthenticationResponsePayload;
import com.teach.me.models.entities.UserEntity;
import com.teach.me.repositories.UserRepository;
import com.teach.me.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    private final AuthenticationManager authenticationManager;
    private final CustomAuthenticationManager customAuthenticationManager;
    private final JwtUtil jwtTokenUtil;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(
            @RequestBody AuthenticationRequestPayload payload
    ) {
        if(userRepository.findFirstByUsername(payload.getUsername())!=null){
            return ResponseEntity.badRequest().body("Already used username");
        }
        else{
            String op=customAuthenticationManager.passwordEncoder().encode(payload.getPassword());
            userRepository.save(new UserEntity(payload.getUsername(), op));
            return  ResponseEntity.ok("\"Data is valid\"");
        }
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponsePayload> createAuthenticationToken(
            @RequestBody AuthenticationRequestPayload payload
    ) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(payload.getUsername(), payload.getPassword())
            );
        } catch (AuthenticationException e) {
            e.printStackTrace();
            throw new RuntimeException("Error authenticating!");
        }

        final String jwt = jwtTokenUtil.generateToken(payload.getUsername());

        return ResponseEntity.ok(new AuthenticationResponsePayload(jwt));
    }

}


