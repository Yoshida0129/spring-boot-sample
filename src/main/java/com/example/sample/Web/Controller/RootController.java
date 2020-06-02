package com.example.sample.Web.Controller;

import com.example.sample.Server.Domains.AccountDomain;
import com.example.sample.Web.Forms.CreateAccountForm;
import com.example.sample.Server.Service.AccountService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class RootController {
	@Autowired
	AccountDomain account;
	@Autowired
	AccountService service;

  @RequestMapping("")
	public String hello(){
		return "index";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String accountCreate(@Validated @ModelAttribute CreateAccountForm form, BindingResult result, Model model){
		if(result.hasErrors()) return "error";
		BeanUtils.copyProperties(form, account);
		service.save(account);

		return "redirect:/result";
	}
}