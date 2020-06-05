package com.example.sample.Gateway.Repository;

import com.example.sample.Gateway.Entity.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
  public Account findByName(String hashPassword);
}
