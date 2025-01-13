package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.tka.entity.User;
import com.tka.service.UserService;

@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean loginHandler(User user) {
		Session session = sessionFactory.openSession();

		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", user.getUsername()));
		criteria.add(Restrictions.eq("password", user.getPassword()));

		List<User> userList = criteria.list();
		if (userList != null && userList.size() == 1) {
			return true;
		} else {

			return false;
		}

	}

	public String registerUser(User user, Model model) {

		Session session = sessionFactory.openSession();
		session.save(user);
		session.beginTransaction().commit();
		model.addAttribute("success", "Registration Successful..");
		return "login";
	}

	public User getUserByEmail(String email) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));
		List<User> userList = criteria.list();
		for (User user : userList) {
			return user;
		}
		return null;
	}

	public String updatePassword(String newpass, Model model) {

		Session session = sessionFactory.openSession();
		User user = getUserByEmail(UserService.getEmailId());
		System.err.println(UserService.getEmailId());
		if (user != null) {
			user.setPassword(newpass);
			session.update(user);
			session.beginTransaction().commit();
			model.addAttribute("changed", "Password Updated Successfully..");
			return "login";
		} else {
			model.addAttribute("wrong", "Something went wrong. Cannot update password.");
			return "resetpassword";
		}

	}

	public User getUserByUsername(String username) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		List<User> user = criteria.list();
		for (User user2 : user) {
			
			return user2;
		}
		return null;
	}

	public String editUserDetails(User user, Model model) {
		Session session = sessionFactory.openSession();
		User existingUser = getUserByUsername(user.getUsername());
		
		if(existingUser != null) {
			System.err.println("User Id from user>>>> "+user.getId());
			System.err.println("User Id from getuserbyUsername method>>>> "+existingUser.getId());
			System.err.println("User Id from getuserbyUsername method>>>> "+existingUser.getEmail());
			System.err.println("User Id from getuserbyUsername method>>>> "+existingUser.getUsername());
			existingUser.setUsername(user.getUsername());
			existingUser.setEmail(user.getEmail());
			existingUser.setPassword(user.getPassword());
			session.update(existingUser);
			session.beginTransaction().commit();
			model.addAttribute("success", "Details Updated Successfully..");
			return "redirect:/api/ipl/user/profile";
		}else {
			model.addAttribute("error", "Cannot update user..");
			return "profile";
		}

	}

}
