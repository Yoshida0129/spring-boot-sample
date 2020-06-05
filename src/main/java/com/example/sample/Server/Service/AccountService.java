package com.example.sample.Server.Service;

import java.sql.Date;
import java.util.List;

import com.example.sample.Server.Domains.AccountDomain;
import com.example.sample.Gateway.Entity.Account;
import com.example.sample.Gateway.Repository.AccountRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  private final Date DATE_NOW = new Date(System.currentTimeMillis());

  @Autowired
  AccountRepository AccountRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  AuthenticationManager manager;

  public List<Account> findAll(){
    List<Account> res = AccountRepository.findAll();
    return res;
  }

  public Account findOne(String userName){
    return AccountRepository.findByName(userName);
  }

  public void save(AccountDomain domain){
    Account account = new Account(DATE_NOW);
    account.setCreated_at(DATE_NOW);
    BeanUtils.copyProperties(domain, account);
    account.setPassword(passwordEncoder.encode(account.getPassword()));
    account = AccountRepository.save(account);
    this.authentication(account, domain.getPassword());
  }

  private void authentication(Account user, String rawPassword) {
    LoginUser loginUser = new LoginUser(user);
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, rawPassword, loginUser.getAuthorities());
    manager.authenticate(authenticationToken);
    if (authenticationToken.isAuthenticated()) {
      SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    } else {
      throw new RuntimeException("login failure");
    }
  }
}