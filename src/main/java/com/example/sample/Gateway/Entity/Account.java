package com.example.sample.Gateway.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Entity
@Table(name="account")
public class Account {
  @Getter @Setter
  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;

  @Getter @Setter
  @Column(name="name", nullable=false)
  private String name;

  @Getter @Setter
  @Column(name="password", nullable=false)
  private String password;

  @Getter @Setter
  @Column(name="created_at")
  private Date created_at;

  @Getter @Setter
  @Column(name="updated_at")
  private Date updated_at;

  public Account(){

  }

  public Account(Date date){
    this.updated_at = date;
  }

}