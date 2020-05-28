package com.example.sample.Forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AccountForm {
  @NotNull
  @Size(min = 5, max = 30)
  private String id;

  @NotNull
  @Size(min = 8, max = 16)
  private String password;

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}