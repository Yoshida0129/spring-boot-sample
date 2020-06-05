package com.example.sample.Server.Service;

import com.example.sample.Gateway.Entity.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  AccountService service;

  @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
      Account user = null;
      try {
        user = service.findOne(loginName);
      } catch (Exception e) {
        throw new UsernameNotFoundException("It can not be acquired User");
      }

      if(user == null) throw new UsernameNotFoundException("User not found for login id: " + loginName);

      return new LoginUser(user);
    }
}