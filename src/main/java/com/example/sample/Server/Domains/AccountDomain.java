package com.example.sample.Server.Domains;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
public class AccountDomain {
  @Getter @Setter
  private String name;
  @Getter @Setter
  private String password;
}