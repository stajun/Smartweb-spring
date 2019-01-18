package kr.green.spring.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.AccountService;
import kr.green.spring.vo.AccountVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost() {
		
		return "redirect:/";
	}
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupGet(Boolean fail, Model model) {
		model.addAttribute("fail", fail);
		return "account/signup";
	}
	//int -> Integer, double -> Double, boolean -> Boolean
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(AccountVo accountVo,Model model) {
		if(accountService.signup(accountVo))
			return "redirect:/";
		else {
			model.addAttribute("fail",true);
			return "redirect:/signup";
		}
	}
}
