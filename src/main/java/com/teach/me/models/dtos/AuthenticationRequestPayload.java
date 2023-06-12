package com.teach.me.models.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequestPayload {
  private String username;
  private String password;
}
