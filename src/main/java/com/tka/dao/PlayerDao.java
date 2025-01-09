package com.tka.dao;

import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Player;
import com.tka.entity.Team;

@Repository
public class PlayerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Player save(Player player) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(player);
		session.close();
		return player;
	}

	public Player findById(Long id) {
		Session session = sessionFactory.openSession();
		return session.get(Player.class, id);
	}

	public List<Player> findAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Player.class);
		criteria.addOrder(org.hibernate.criterion.Order.asc("id"));
		List< Player> players =  criteria.list();
		session.close();
		return players;
	}

	public Object updatePlayer(Player player, Long id) {
		Session session = sessionFactory.openSession();
		Player player2 = session.get(Player.class, id);
		if (player2 != null) {
			player2.setAge(player.getAge());
			player2.setName(player.getName());
			session.saveOrUpdate(player2);
			session.beginTransaction().commit();
			session.close();
			return "Player updated Successfully...";
		} else {

			return "Player Not Found..";
		}

	}

	public String deletePlayer(Long id) {
		Session session = sessionFactory.openSession();
		Player player = session.get(Player.class, id);
		if (player != null) {
			session.delete(player);
			session.beginTransaction().commit();
			return "Player Deleted Successfully..";
		} else {
			session.close();
			return "Player Not Found.";
			
		}
	}
	
	public Player getPlayerByName(String name) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Player.class);
		criteria.add(Restrictions.eq("name", name));

		List<Player> list = criteria.list();
		for (Player player : list) {
			return player;
		}
		session.close();
		return null;
	}

	public List<Player> getPlayersByPattern(String pattern) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Player.class);
		criteria.add(Restrictions.like("name", pattern, MatchMode.ANYWHERE));

		List list = criteria.list();
		session.close();
		return list;

	}
	
}
