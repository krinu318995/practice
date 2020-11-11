package com.knr.springapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.knr.springapp.service.IUserService;
import com.knr.springapp.vo.UserVO;

@Controller
public class LoginController {
	@Autowired
	IUserService userservice;

	@Autowired
	BCryptPasswordEncoder bpe;

	@GetMapping(value = "/login")
	public String login(Model model) {
		return "emp/login";
		
	}
	
	
	@PostMapping(value = "/login")
	public String login(String id, String pw, Model model, HttpSession session) {
		String dbpw = userservice.getPassword(id);
		if (dbpw != null & bpe.matches(pw, dbpw)) {
			UserVO user = userservice.getUserInfo(id);
			session.setAttribute("user", user);
			session.setAttribute("userId", id);
			return "redirect:/emp";
		} else {
		model.addAttribute("message", "dd");
			return "redirect:emp/login";
		}

	}
}
