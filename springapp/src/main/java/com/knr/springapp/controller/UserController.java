package com.knr.springapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.knr.springapp.service.IUserService;
import com.knr.springapp.vo.UserVO;

@Controller
@RequestMapping(value = "/emp")
public class UserController {

	@Autowired
	IUserService userService;

	@GetMapping(value = "/signup")
	public String insertUser(Model model) {
		model.addAttribute("user", new UserVO());
		
		
		return "emp/signup";

	}

	@PostMapping(value = "/signup")
	public String insertUser(@ModelAttribute("emp") @Valid UserVO user, BindingResult result,
			@RequestParam(value = "file") MultipartFile file, RedirectAttributes reAtt, HttpServletResponse res) throws IOException {

		if (file != null && !file.isEmpty()) {
			try {
				user.setPicture(file.getBytes());
				user.setPictureSize(file.getSize());
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
		userService.insertUser(user);
		PrintWriter out = res.getWriter();
		out.println("<script>");
		out.println("alert('회원가입 완료');");
		out.println("</script>");
		reAtt.addFlashAttribute("message", "회원 가입 완료");
		return "redirect:/login";
	}

	@PostMapping(value = "/idcheck")
	@ResponseBody
	public String userIdCheck(String userId) {
		return userService.userIdCheck(userId) == 0 ? "true" : null ;
		
	}

}
