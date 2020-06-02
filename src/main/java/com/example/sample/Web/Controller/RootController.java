package com.example.sample.Web.Controller;

import com.example.sample.Server.Domains.AccountDomain;
import com.example.sample.Web.Forms.AccountForm;
import com.example.sample.Server.Service.AccountService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class RootController {
	@Autowired
	AccountDomain accountDomain;
	@Autowired
	AccountService service;

  @RequestMapping("")
	public String homeScreen(){
		return "index";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String accountCreateScreen(){
		return "create";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String accountCreate(@Validated @ModelAttribute AccountForm form, BindingResult result, Model model, ModelMap modelmap){
		if(result.hasErrors()){
			modelmap.addAttribute("errorMsg", "フォーム値が不適切です。");
			return "redirect:/create";
		}
		BeanUtils.copyProperties(form, accountDomain);
		try{
			service.save(accountDomain);
		}catch(Exception e){
			modelmap.addAttribute("errorMsg", "ユーザ名は登録されています。");
			return "create";
		}
		return "redirect:/result";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginScreen(){
		return "login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@Validated @ModelAttribute AccountForm form, BindingResult result, Model model, ModelMap modelmap){
		if(result.hasErrors()){
			modelmap.addAttribute("errorMsg", "フォーム値が不適切です。");
			return "login";
		}
		BeanUtils.copyProperties(form, accountDomain);
		try {
			String accountName = service.login(accountDomain);
			return "redirect:result/" + accountName;
		} catch (Exception e){
			modelmap.addAttribute("errorMsg", e.getMessage());
			return "login";
		}
	}
}