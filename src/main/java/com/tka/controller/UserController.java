package com.tka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tka.entity.User;
import com.tka.service.UserService;

@Controller
@RequestMapping("api/ipl/user")
public class UserController {


	@Autowired
	private UserService userService;

	User user = new User();

	@GetMapping("/")
	public String loginPage() {
		return "login";
	}

	@PostMapping("loginhandle")
	public String loginHandler(@ModelAttribute User user, Model model) {
		boolean correct = userService.loginHandler(user);
		if (correct) {

			model.addAttribute("name", user.getUsername());
			return "choose";
		} else {
			model.addAttribute("error", "Invalid Username or Password");
			model.addAttribute("name", user.getUsername());
			return "login";
		}
	}

	@GetMapping("registration")
	public String registerUser() {
		return "registration";
	}

	@PostMapping("handleregister")
	public String registerUser(@ModelAttribute User user, Model model) {
		return userService.registerUser(user, model);
	}

	@GetMapping("choice")
	public String chooseOperation() {

		return "choose";
	}

	@GetMapping("forgot")
	public String getForgotPassPage() {
		return "forgot";
	}

	@PostMapping("forgot-handler")
	public String handleForgotRequest(@RequestParam String email, Model model) {
		System.err.println("Email Address : " + email);
		return userService.handleForgotRequest(email, model);
	}

	@PostMapping("otp-handler")
	public String getOTPFromUser(@RequestParam int otp, Model model) {
		System.err.println("OTP in controller : " + otp);
		return userService.getOTPFromUser(otp, model);
	}

	@PostMapping("reset-pass")
	public String updatePassword(@RequestParam String newpass, @RequestParam String confirm, Model model) {
		return userService.updatePassword(newpass, confirm, model);
	}

}
