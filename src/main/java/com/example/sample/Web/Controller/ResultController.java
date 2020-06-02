package com.example.sample.Web.Controller;

import java.util.List;

import com.example.sample.Gateway.Entity.Account;
import com.example.sample.Server.Service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/result")
public class ResultController {
	@Autowired
  AccountService service = new AccountService();
  
	@RequestMapping("")
	public String result(ModelMap modelMap){
    List<Account> accountData = service.findAll();
    modelMap.addAttribute("accountData", accountData);
		return "result";
	}
}