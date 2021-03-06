package com.example.sample.Web.Controller;

import java.util.List;

import com.example.sample.Gateway.Entity.Account;
import com.example.sample.Server.Service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// 追々adminページにする予定

@Controller
@RequestMapping("/result")
public class ResultController {
	@Autowired
  AccountService service;

	@RequestMapping("")
	public String result(ModelMap modelMap){
    List<Account> accountData = service.findAll();
    modelMap.addAttribute("accountData", accountData);
		return "result";
	}

	@RequestMapping("/{accountName}")
	public String result(ModelMap modelMap, @PathVariable String accountName){
		Account accountData = service.findOne(accountName);
		modelMap.addAttribute("accountData", accountData);
		return "result";
	}
}