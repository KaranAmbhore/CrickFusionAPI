package com.tka.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.entity.Matches;
import com.tka.entity.Team;
import com.tka.exceptions.MatchNotFoundException;

@Repository
public class MatchDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Matches save(Matches matches) {
		Session session = sessionFactory.openSession();
		session.save(matches);
		return matches;
	}

	public Matches findById(Long id) {
		Session session = sessionFactory.openSession();
		return session.get(Matches.class, id);
	}

	public List<Matches> findAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Matches.class);
		return criteria.list();
	}

	public Object updateMatch(Matches matches, Long id) {
		Session session = sessionFactory.openSession();
		Matches match = session.get(Matches.class, id);
		if (match != null) {
			match.setLocation(matches.getLocation());
			match.setMatchDate(matches.getMatchDate());
			match.setTeam1(matches.getTeam1());
			match.setTeam2(matches.getTeam2());
			session.saveOrUpdate(match);
			session.beginTransaction().commit();
			return "Match Updated Successfully..";
		} else {

			return "Match Not Found";
		}

	}

	public String deleteMatch(Long id) {
		Session session = sessionFactory.openSession();
		Matches match = session.get(Matches.class, id);
		try {

			if (match != null) {
				session.delete(match);
				session.beginTransaction().commit();
				return "Match deleted successfully..";
			} else {
				throw new MatchNotFoundException("Match Not Found In the Database.");
			}

		} catch (MatchNotFoundException e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

	}

	public Matches getMatchesByName(String date) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Matches.class);
		criteria.add(Restrictions.eq("matchDate", date));

		List<Matches> list = criteria.list();
		for (Matches match : list) {
			return match;
		}
		return null;
	}

	public List<Matches> getMatchessByPattern(String pattern) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Matches.class);
		criteria.add(Restrictions.like("matchDate", pattern, MatchMode.ANYWHERE));

		List list = criteria.list();
		return list;

	}

	public Object getMatchByTeam(Long teamId) {
		Session session = sessionFactory.openSession();
		Team team = session.get(Team.class, teamId);
		List<Matches> matches = findAll();
		for (Matches match : matches) {
			if (team != null && match.getTeam1().getId() == teamId || match.getTeam2().getId() == teamId) {
				return match;
			}
		}

		return "Match Not Found";
	}

	public Object getMatchByTeamName(String teamName) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Team.class);
		criteria.add(Restrictions.eq("name", teamName));
		List<Matches> matches = findAll();
		List<Matches> allPresentMatches = new ArrayList<>();
		List<Team> list = criteria.list();
		for (Team team : list) {
			for (Matches match : matches) {
				if (list != null && team != null && match.getTeam1().getName().equalsIgnoreCase(teamName)
						|| match.getTeam2().getName().equalsIgnoreCase(teamName)) {
					allPresentMatches.add(match);
//					return match;
				}
			}

		}

		return allPresentMatches;

	}

	public List<Matches> getMatchByVenue(String venue) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Matches.class);
		criteria.add(Restrictions.eq("location", venue));
		List<Matches> list = criteria.list();

		return list;
	}
	public List<Matches> getMatchByVenuePattern(String venue) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Matches.class);
		criteria.add(Restrictions.like("location", venue, MatchMode.ANYWHERE));
		List<Matches> list = criteria.list();
		
		return list;
	}

}
