package com.board.study.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.study.service.GoogleService;

@Controller
public class LoginController {

	GoogleService loginService;

	public LoginController(GoogleService loginService) {
		this.loginService = loginService;
	}

	@GetMapping("/login/oauth2/code/{registrationId}")
	public String googleLogin(Model model, @RequestParam String code, @PathVariable String registrationId) {
		String name = loginService.socialLogin(code, registrationId);
		model.addAttribute("user", name);
		return "/board/loginResult";
	}
}
