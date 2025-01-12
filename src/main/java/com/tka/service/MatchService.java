package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tka.dao.MatchDao;
import com.tka.entity.Matches;

@Service
public class MatchService {

	@Autowired
	private MatchDao matchDao;

//	public Matches createMatch(Matches matches) {
//		return matchDao.save(matches);
//	}
//
	
//
//	public List<Matches> getAllMatches() {
//		return matchDao.findAll();
//	}
//
//	public Object updateMatch(Matches matches, Long id) {
//		return matchDao.updateMatch(matches, id);
//	}
//
//	public String deleteMatch(Long id) {
//		return matchDao.deleteMatch(id);
//	}
//
//	public Object getMatchesByName(String date) {
//		return matchDao.getMatchesByName(date);
//	}
//
//	public Object getMatchessByPattern(String pattern) {
//		return matchDao.getMatchessByPattern(pattern);
//	}
//
//	public Object getMatchByTeam(Long teamId) {
//
//		return matchDao.getMatchByTeam(teamId);
//	}
//
//	public Object getMatchByTeamName(String teamName) {
//
//		Object matches = matchDao.getMatchByTeamName(teamName);
//
//		if (matches != null) {
//
//			return matches;
//		} else {
//			return "Currently " + teamName + " has no upcoming matches.";
//		}
//	}
//
//	public Object getMatchByVenue(String venue) {
//		List<Matches> list = matchDao.getMatchByVenue(venue);
//
//		if (!list.isEmpty()) {
//			return list;
//
//		} else {
//			return "Invalid Venue or There are currently no matches for this venue";
//		}
//
//	}
//	
//	Service methods from user service...
	
	
	
	public String addMatch(Matches match, Model model) {
		if (match != null) {
			matchDao.save(match);
			model.addAttribute("success", "Match Added Successfully.");
			return "addmatch";
		} else {
			model.addAttribute("error", "Error Adding Match, Please try again later.");
			return "addmatch";
		}
	}
	
	public Matches getMatchById(Long id) {
		return matchDao.findById(id);

	}
	
	public String getAllMatches(Model model) {

		List<Matches> matches = matchDao.findAll();
		model.addAttribute("matches", matches);

		return "allmatches";
	}

	public String getMatchByVenue(String input, Model model) {
//		System.out.println(matches);
		List<Matches> matches = matchDao.getMatchByVenuePattern(input);
		List<Matches> matchesByVenue = (List<Matches>) matchDao.getMatchessByPattern(input);
		if (!matches.isEmpty()) {
			model.addAttribute("matches", matches);
			System.err.println(matches);
			return "getmatch";
		} else if(!matchesByVenue.isEmpty()) {
			model.addAttribute("matches", matchesByVenue);
			System.err.println(matchesByVenue);
			return "getmatch";
		}else {
			model.addAttribute("error", "Match Not Found");
			return "getmatch";
		}
	}
	
		public String updateMatch(Matches match, Model model) {

			Matches existingMatch = matchDao.findById(match.getId());
			if (existingMatch != null) {
				existingMatch.setMatchDate(match.getMatchDate());
				existingMatch.setLocation(match.getLocation());
				existingMatch.setTeam1(match.getTeam1());
				existingMatch.setTeam2(match.getTeam2());
				matchDao.updateMatch(existingMatch, match.getId());
//				List<Matches> matches = matchController.getAllMatches();
//				model.addAttribute("matches", matches);
				return "redirect:/api/matches/allmatches";
			} else {
				model.addAttribute("error", "Match Not Found");
				return "updatematch";
			}

		}

		public String deleteMatch(Long id, Model model) {
			Matches match = matchDao.findById(id);
			if (match != null) {
				matchDao.deleteMatch(id);
//				List<Matches> matches = matchController.getAllMatches();
//				model.addAttribute("matches", matches);
				return "redirect:/api/matches/allmatches";
			} else {
				model.addAttribute("error", "Match Not Found");
				return "allmatches";
			}

		}

}
