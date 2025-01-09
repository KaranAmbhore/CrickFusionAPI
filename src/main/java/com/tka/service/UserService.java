package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tka.controller.MatchController;
import com.tka.controller.PlayerController;
import com.tka.controller.TeamController;
import com.tka.dao.MatchDao;
import com.tka.dao.UserDao;
import com.tka.entity.Matches;
import com.tka.entity.Player;
import com.tka.entity.Team;
import com.tka.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PlayerController playerController;

	@Autowired
	TeamController teamController;

	@Autowired
	private MatchDao matchDao;
	@Autowired
	private MatchController matchController;

	public boolean loginHandler(User user) {

		return userDao.loginHandler(user);
	}

	public String getPlayerByName(String name, Model model) {

		List<Player> players = playerController.getPlayersByPattern(name);
		System.err.println(players);
		if (!players.isEmpty()) {
			model.addAttribute("players", players);
			return "playerbyname";
		} else {
			model.addAttribute("error", "Player Not found");
			return "playerbyname";
		}

	}

	public String addPlayer(Player player, Model model) {

		Team team = teamController.getTeamById(player.getTeam().getId());

		if (player != null && team != null) {
			playerController.createPlayer(player);
			model.addAttribute("message", "Player Added Successfully...");
			return "register";
		} else {
			model.addAttribute("error", "Cannot add Player.No team with Id " + player.getTeam().getId() + " found.");
			model.addAttribute("name", player.getName());
			model.addAttribute("age", player.getAge());
			model.addAttribute("teamid", player.getTeam().getId());
			return "register";
		}

	}

	public String updatePlayer(Player player, Model model) {

		Player player2 = playerController.getPlayerById(player.getId());
		if (player2 != null) {
			player2.setAge(player.getAge());
			player2.setName(player.getName());
			player2.setTeam(player.getTeam());
			playerController.updatePlayer(player2, player.getId());
			List<Player> players = playerController.getAllPlayers();
			model.addAttribute("players", players);
			return "allplayers";
		} else {
			model.addAttribute("error", "Cannot update player details right now..");
			return "update";
		}

	}

	public String deletePlayer(Long id, Model model) {
		if (id != 0) {
			playerController.deletePlayer(id);
			List<Player> players = playerController.getAllPlayers();
			model.addAttribute("players", players);
			return "allplayers";
//			return "demoplayers";
		} else {
			model.addAttribute("error", "Player Not Found");
			return "delete";
		}

	}

	public String addTeam(Team team, Model model) {

		if (team != null) {
			teamController.createTeam(team);
			model.addAttribute("message", "Team Added Successfully..");
			return "addteam";
		} else {
			model.addAttribute("error", "Error creating team.Please try again..");
			return "addteam";
		}

	}

	public String getAllTeams(Model model) {

		List<Team> teams = teamController.getAllTeams();
		model.addAttribute("teams", teams);
		return "allteams";
	}

	public String getAllMatches(Model model) {

		List<Matches> matches = matchController.getAllMatches();
		model.addAttribute("matches", matches);

		return "allmatches";
	}

	public String getTeamByName(String name, Model model) {

		List<Team> teams = teamController.getTeamsByPattern(name);
		if (teams != null) {
			model.addAttribute("teams", teams);
			return "teambyname";
		} else {
			model.addAttribute("error", "Team Not Found");
			return "teambyname";
		}
	}

	public String updateTeam(Team team, Model model) {

		Team team2 = teamController.getTeamById(team.getId());
		if (team2 != null) {
			team2.setName(team.getName());
			teamController.updateTeam(team2, team.getId());
			List<Team> teams = teamController.getAllTeams();
			model.addAttribute("teams", teams);
			return "allteams";
		} else {
			model.addAttribute("error", "Team With Id " + team.getId() + " Not Found");
			return "updateteam";
		}

	}

	public String deleteTeam(Long id, Model model) {
		if (id != 0) {
			teamController.deleteTeam(id);
			List<Team> teams = teamController.getAllTeams();
			model.addAttribute("teams", teams);
			return "allteams";
		} else {
			model.addAttribute("error", "Team Id Cannot be zero.");
			return "deleteteam";
		}
	}

	public String addMatch(Matches match, Model model) {
		if (match != null) {
			matchController.createMatch(match);
			model.addAttribute("success", "Match Added Successfully.");
			return "addmatch";
		} else {
			model.addAttribute("error", "Error Adding Match, Please try again later.");
			return "addmatch";
		}
	}

	public String getMatchByVenue(String input, Model model) {
//		System.out.println(matches);
		List<Matches> matches = matchDao.getMatchByVenuePattern(input);
		List<Matches> matchesByVenue = (List<Matches>) matchController.getMatchessByPattern(input);
		if (!matches.isEmpty()) {
			model.addAttribute("matches", matches);
			System.out.println(matches);
			return "getmatch";
		} else if(!matchesByVenue.isEmpty()) {
			model.addAttribute("matches", matchesByVenue);
			System.out.println(matches);
			return "getmatch";
		}else {
			model.addAttribute("error", "Match Not Found");
			return "getmatch";
		}

	}
//	public String getMatchByName(String input, Model model) {
//		List<Matches> matches = (List<Matches>) matchController.getMatchessByPattern(input);
//		System.out.println(matches);
//		if (!input.isEmpty()) {
//			model.addAttribute("matches", matches);
//			return "getmatch";
//		} else {
//			model.addAttribute("error", "Match Not Found");
//			return "getmatch";
//		}
//		
//	}

	public String updateMatch(Matches match, Model model) {

		Matches existingMatch = matchController.getMatchById(match.getId());
		if (existingMatch != null) {
			existingMatch.setMatchDate(match.getMatchDate());
			existingMatch.setLocation(match.getLocation());
			existingMatch.setTeam1(match.getTeam1());
			existingMatch.setTeam2(match.getTeam2());
			matchController.updateMatch(existingMatch, match.getId());
			List<Matches> matches = matchController.getAllMatches();
			model.addAttribute("matches", matches);
			return "allmatches";
		} else {
			model.addAttribute("error", "Match Not Found");
			return "updatematch";
		}

	}

	public String deleteMatch(Long id, Model model) {
		Matches match = matchController.getMatchById(id);
		if (match != null) {
			matchController.deleteMatch(id);
			List<Matches> matches = matchController.getAllMatches();
			model.addAttribute("matches", matches);
			return "allmatches";
		} else {
			model.addAttribute("error", "Match Not Found");
			return "allmatches";
		}

	}

}
