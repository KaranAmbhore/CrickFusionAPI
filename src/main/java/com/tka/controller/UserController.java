package com.tka.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String loginHandler(@ModelAttribute User user, Model model, HttpSession session) {
		boolean correct = userService.loginHandler(user);
		if (correct) {

			model.addAttribute("name", user.getUsername());
			User existingUser = userService.getUserByUsername(user.getUsername());
			System.err.println(existingUser);
			session.setAttribute("existinguser", existingUser);
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
		System.out.println(user);
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

	@GetMapping("navbar")
	public String getNavbar() {
		return "navbar";
	}

	@GetMapping("profile")
	public String getProfilePage(@ModelAttribute User existingUser) {
		return "profilepage";
	}

	@GetMapping("edituser")
	public String editUserDetailsButton(Model model) {

		boolean enableEdit = true;
		model.addAttribute("enableEdit", enableEdit);

		return "profilepage";
	}

	@PostMapping("edituserdetails")
	public String editUserDetails(@ModelAttribute User user, Model model) {

		System.err.println("User Id : " + user.getId());
		System.err.println("Username : " + user.getUsername());
		System.err.println("Email : " + user.getEmail());
		System.err.println("Password : " + user.getPassword());
		return userService.editUserDetails(user, model);
	}

	@GetMapping("getusername")
	public String getUserByUserName(String username, Model model) {

		User user = userService.getUserByUsername(username);
		if (user != null) {
			return "choose";
		} else {
			return "login";
		}

	}

	@GetMapping("logout")
	public String logOutImpl(HttpSession httpSession) {

		httpSession.invalidate();

		return "login";
	}

	@GetMapping("all-users-page")
	public String getAllUsersPage() {
		return "allusers";
	}

	@GetMapping("all-users")
	public String getAllUsers(Model model) {
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		return "allusers";
	}

	@GetMapping("playerschoice")
	public String getPlayersChoice() {
		return "getplayerschoice";
	}

	@GetMapping("teamschoice")
	public String getTeamsChoice() {
		return "teamschoice";
	}

	@GetMapping("matcheschoice")
	public String getMatchesChoice() {
		return "matcheschoice";
	}

	@GetMapping("make-admin/{userId}")
	public String makeAdmin(@PathVariable Long userId) {
		System.out.println(userId);
		
		return userService.makeAdmin(userId);
	}
}
