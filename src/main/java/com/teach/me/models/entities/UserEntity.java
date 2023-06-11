package com.teach.me.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "app_user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @Column(name="username")
  private String username;
  @Column(name="password")
  private String password;

  public UserEntity(String username, String password) {
    this.username=username;
    this.password=password;
  }
}
