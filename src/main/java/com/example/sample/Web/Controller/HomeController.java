package com.example.sample.Web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
  @RequestMapping("")
  public String HomeScreen(){
    return "home";
  }
}