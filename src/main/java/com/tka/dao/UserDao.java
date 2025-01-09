package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.User;

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
		if(userList != null && userList.size()==1) {
			return true;
		}else {
			
			return false;
		}
		
	}

	
	
}
