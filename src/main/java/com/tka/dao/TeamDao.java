package com.tka.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Player;
import com.tka.entity.Team;

@Repository
public class TeamDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Team save(Team team) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(team);
		return team;
	}

	public Team findById(Long id) {
		Session session = sessionFactory.openSession();
		return session.get(Team.class, id);
	}

	public List<Team> findAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Team.class);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}

	public Object updateTeam(Team team, Long id) {

		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Team.class);

		Team team2 = session.get(Team.class, id);
		System.out.println(team2);
		if (team2 != null) {

			team2.setName(team.getName());
//			team2.setPlayers(team.getPlayers());
			session.update(team2);
			session.beginTransaction().commit();
			return team2;
		} else {

			return "Team Not Found";
		}

	}

	public String deleteTeam(Long id) {
		Session session = sessionFactory.openSession();
		Team team = session.get(Team.class, id);
		if (team != null) {
			session.delete(team);
			session.beginTransaction().commit();
			return "Team Deleted Successfully..";
		} else {

			return "Team Not Found.";
		}

	}

	public Team getTeamByName(String name) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Team.class);
		criteria.add(Restrictions.eq("name", name));

		List<Team> list = criteria.list();
		for (Team team : list) {
			return team;
		}
		return null;
	}

	public List<Team> getTeamsByPattern(String pattern) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Team.class);
		criteria.add(Restrictions.like("name", pattern, MatchMode.ANYWHERE));

		List list = criteria.list();
		return list;

	}
	
	public List<Player> playersInTeam(Long id){
		Session session = sessionFactory.openSession();
		Team team = session.get(Team.class, id);
		if(team != null) {
			
			return team.getPlayers();
		}else {
			
			return null;
		}
		
	}

	public List<Player> playersInTeams(String name) {
		Session session =sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Team.class);
		criteria.add(Restrictions.eq("name", name));
		
		List<Team> list = criteria.list();
		for (Team object : list) {
			return object.getPlayers();
		}
		return null;
	}
}
