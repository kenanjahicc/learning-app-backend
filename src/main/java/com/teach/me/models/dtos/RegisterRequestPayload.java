package com.teach.me.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class RegisterRequestPayload {
    private String username;
    private String password;
    private String role;
    private String email;
}