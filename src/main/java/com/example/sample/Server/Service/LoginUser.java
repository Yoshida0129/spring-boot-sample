package com.example.sample.Server.Service;

import com.example.sample.Gateway.Entity.Account;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

public class LoginUser extends User {
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  @Getter
  private final Account account;

  public LoginUser(Account account){
    super(account.getName(), account.getPassword(), AuthorityUtils.createAuthorityList("hoge"));
    this.account = account;
  }
}