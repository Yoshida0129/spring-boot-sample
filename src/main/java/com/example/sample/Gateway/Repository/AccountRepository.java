package com.example.sample.Gateway.Repository;

import java.util.List;

import com.example.sample.Gateway.Entity.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
  @Query(value="SELECT * FROM account;", nativeQuery = true)
  public List<Account> validatePassword(String hashPassword);
}
