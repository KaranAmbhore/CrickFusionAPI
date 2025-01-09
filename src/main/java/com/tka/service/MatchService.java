package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.MatchDao;
import com.tka.entity.Matches;

@Service
public class MatchService {

	@Autowired
	private MatchDao matchDao;

	public Matches createMatch(Matches matches) {
		return matchDao.save(matches);
	}

	public Matches getMatchById(Long id) {
		return matchDao.findById(id);

	}

	public List<Matches> getAllMatches() {
		return matchDao.findAll();
	}

	public Object updateMatch(Matches matches, Long id) {
		return matchDao.updateMatch(matches, id);
	}

	public String deleteMatch(Long id) {
		return matchDao.deleteMatch(id);
	}

	public Object getMatchesByName(String date) {
		return matchDao.getMatchesByName(date);
	}

	public Object getMatchessByPattern(String pattern) {
		return matchDao.getMatchessByPattern(pattern);
	}

	public Object getMatchByTeam(Long teamId) {

		return matchDao.getMatchByTeam(teamId);
	}

	public Object getMatchByTeamName(String teamName) {

		Object matches = matchDao.getMatchByTeamName(teamName);

		if (matches != null) {

			return matches;
		} else {
			return "Currently " + teamName + " has no upcoming matches.";
		}
	}

	public Object getMatchByVenue(String venue) {
		List<Matches> list = matchDao.getMatchByVenue(venue);

		if (!list.isEmpty()) {
			return list;

		} else {
			return "Invalid Venue or There are currently no matches for this venue";
		}

	}

}
