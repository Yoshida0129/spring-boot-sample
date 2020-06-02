package com.example.sample.Server.Service;

import java.sql.Date;
import java.util.List;

import com.example.sample.Server.Domains.AccountDomain;
import com.example.sample.Gateway.Entity.Account;
import com.example.sample.Gateway.Repository.AccountRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {
  private final Date DATE_NOW = new Date(System.currentTimeMillis());

  @Autowired
  AccountRepository AccountRepository;

  public List<Account> findAll(){
    List<Account> res = AccountRepository.findAll();
    return res;
  }

  public void save(AccountDomain domain){
    Account account = new Account(DATE_NOW);
    account.setCreated_at(DATE_NOW);
    BeanUtils.copyProperties(domain, account);
    AccountRepository.save(account);
  }
}