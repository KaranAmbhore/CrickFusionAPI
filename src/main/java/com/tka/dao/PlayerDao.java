package com.tka.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tka.entity.Player;
import com.tka.entity.PlayerDetails;

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
		List<Player> players = criteria.list();
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

	public List<PlayerDetails> getAllPlayerDetails() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(PlayerDetails.class);
		return criteria.list();
	}

	public PlayerDetails getPlayerDetailsById(Long id) {
		Session session = sessionFactory.openSession();
		PlayerDetails player = session.get(PlayerDetails.class, id);

		return player;
	}

	public Object updatePlayerDetails(PlayerDetails player, Model model) {
		Session session = sessionFactory.openSession();
		PlayerDetails player2 = session.get(PlayerDetails.class, player.getPlayerId());
		if (player2 != null) {
			player2.setAge(player.getAge());
			player2.setPlayerName(player.getPlayerName());
			player2.setPlayerImage(player.getPlayerImage());
			player2.setPlayerRole(player.getPlayerRole());
			player2.setEconomy(player.getEconomy());
			player2.setStrikeRate(player.getStrikeRate());
//			player2.setTeam(player.getTeam());
			player2.setTotalCenturies(player.getTotalCenturies());
			player2.setWickets(player.getWickets());
			player2.setTotalRuns(player.getTotalRuns());
			session.saveOrUpdate(player2);
			session.beginTransaction().commit();
			session.close();
			return "Player updated Successfully...";
		} else {

			return "Player Not Found..";
		}

	}

	public String addNewPlayerDetails(PlayerDetails player) {
		Session session = sessionFactory.openSession();
		session.save(player);
		session.beginTransaction().commit();
		
		return "addnewplayer";
	}

	public String deletePlayerDetails(Long id,RedirectAttributes redirectAttributes) {

		Session session = sessionFactory.openSession();
		PlayerDetails player = session.get(PlayerDetails.class, id);
		session.delete(player);
		session.beginTransaction().commit();
		redirectAttributes.addFlashAttribute("success","Player Deleted Successfully...");
		return "redirect:/api/players/playerdetails";
	}

	
	public List<PlayerDetails> getPlayerDetailsByName(String name){
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(PlayerDetails.class);
		criteria.add(Restrictions.like("playerName", name, MatchMode.ANYWHERE));
		return criteria.list();
				
	}
}
