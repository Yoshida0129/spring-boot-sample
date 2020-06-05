package com.example.sample;

import com.example.sample.Config.SecurityConfig;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
  public SecurityWebApplicationInitializer() {
    super(SecurityConfig.class);
  }
}
