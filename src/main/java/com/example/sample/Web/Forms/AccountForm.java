package com.example.sample.Web.Forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public class AccountForm {
  @Getter @Setter
  @NotNull
  @Size(min = 5, max = 30)
  private String name;

  @Getter @Setter
  @NotNull
  @Size(min = 8, max = 16)
  private String password;

  @Autowired
  PasswordEncoder passwordEncoder;
}