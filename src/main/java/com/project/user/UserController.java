package com.project.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {

	@GetMapping("sign-up")
	public String signUp(Model model) {
		model.addAttribute("mainSection", "user/signUp");
		return"template/layout";
	}
	@GetMapping("sign-in")
	public String signIn(Model model) {
		model.addAttribute("mainSection", "user/signIn");
		return"template/layout";
	}
}
