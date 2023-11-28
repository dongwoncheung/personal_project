package com.project.main;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class mainPageController {

	@GetMapping("/main/main-page")
	public String mainPage(Model model, HttpSession session) {
		model.addAttribute("mainSection", "main/main-Page");
		return "template/layout";
	}
}
