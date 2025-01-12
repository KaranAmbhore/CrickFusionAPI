package com.tka.service;

import java.security.SecureRandom;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tka.dao.UserDao;
import com.tka.entity.EmailInfo;
import com.tka.entity.User;

@Service
public class UserService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private EmailInfo emailInfo;

	@Autowired
	private UserDao userDao;

	private String otp;

	private static String emailId;

	public static String getEmailId() {
		return emailId;
	}

	public static void setEmailId(String emailId) {
		UserService.emailId = emailId;
	}

	public boolean loginHandler(User user) {

		return userDao.loginHandler(user);
	}

	public String generateOTP() {
		SecureRandom random = new SecureRandom();
		int otp = 100000 + random.nextInt(900000);
		return String.valueOf(otp);

	}

	public String registerUser(User user, Model model) {

		if (user != null) {
			return userDao.registerUser(user, model);
		} else {
			model.addAttribute("emptyfield", "User details cannot be empty..All fields are required..");
			return "registration";
		}

	}

	public void sendOTPToEmail(String email, String otp) throws Exception {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		helper.setTo(email);
		helper.setSubject(emailInfo.getSubject());
		helper.setText(emailInfo.getBody() + otp+". "+emailInfo.getBody2());
//		helper.setText(otp);/

		javaMailSender.send(mimeMessage);

	}

	public String handleForgotRequest(String email, Model model) {

		User user = userDao.getUserByEmail(email);
		System.err.println(user);
		emailId = email;
		boolean showOTPForm = true;

		if (user != null) {
			otp = generateOTP();
			try {
				sendOTPToEmail(email, otp);
				model.addAttribute("success", "OTP sent successfully..");
				model.addAttribute("showotpform", showOTPForm);
				model.addAttribute("email", email);
				return "forgot";
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Unable to send otp");
			}
		} else {
			model.addAttribute("error", "Please Enter Email Associated with your account..");
			return "forgot";
		}

	}

	public String getOTPFromUser(int otpFromUser, Model model) {
		System.err.println("OTP from user : " + otpFromUser);
		int generatedOTP = Integer.parseInt(otp);
		System.err.println("Generated OTP : " + generatedOTP);

		if (otpFromUser == generatedOTP) {
			return "resetpassword";
		} else {
			model.addAttribute("invalidotp", "Invalid OTP. Please Re-Enter OTP.");
			return "forgot";
		}

	}

	public String updatePassword(String newpass, String confirm, Model model) {

		System.err.println("New Password : " + newpass);
		System.err.println("Confirm Password : " + confirm);

		if (newpass.equals(confirm)) {
			return userDao.updatePassword(newpass, model);
		} else {
			model.addAttribute("notsame", "Password Doesn't Matches. Try Again..");
			return "resetpassword";
		}

	}

}
