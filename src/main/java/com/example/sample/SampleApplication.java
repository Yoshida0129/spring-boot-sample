package com.example.sample;

import com.example.sample.Forms.AccountForm;
import com.example.sample.Domains.Account;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@SpringBootApplication
@Controller
public class SampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@GetMapping("/")
	public String hello(){
		return "index";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String accountCreate(@Validated @ModelAttribute AccountForm form, BindingResult result, Model model){
		if(result.hasErrors()) return "error";
		Account account = new Account();
		BeanUtils.copyProperties(form, account);
		System.out.println(account.getId());
		return "redirect:/";
	}
}
