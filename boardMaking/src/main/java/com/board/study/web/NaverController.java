package com.board.study.web;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.study.service.NaverService;

@Controller
public class NaverController  {
	NaverService naverService = new NaverService();
	@GetMapping("/auth/naver/callback")
	public String naverCallback(@RequestParam String code, @RequestParam String state) throws IOException {
		String access_Token = naverService.getNaverAccessToken(code);
		String name = naverService.createNaverUser(access_Token);
		System.out.println(name);
		return "board/loginResult";
	}
}
