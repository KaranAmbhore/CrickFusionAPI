package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tka.dao.TeamDao;
import com.tka.entity.Matches;
import com.tka.entity.Player;
import com.tka.entity.PlayerDetails;
import com.tka.entity.Team;

@Service
public class TeamService {

	@Autowired
	private TeamDao teamDao;


	public Team getTeamById(Long id) {
		return teamDao.findById(id);

	}

	public List<Team> getTeamsByPattern(String pattern) {
		List<Team> list = teamDao.getTeamsByPattern(pattern);
		if (list.isEmpty()) {
			return null;
		} else {
			return list;
		}
	}

	public List<Player> playersInTeam(Long id) {
	
		List<Player> players = teamDao.playersInTeam(id);
		if (!players.isEmpty()) {
			return players ;

		}else {
			return null;
		}
	}

	public Object playersInTeams(String name) {
		
		List<Player> list =  teamDao.playersInTeams(name);
		if(list != null) {
			return list;
		}else {
			return  "Team with name "+name+" not found..";
			
		}
	}
	

	public String addTeam(Team team, Model model) {

		if (team != null) {
			teamDao.save(team);
			model.addAttribute("message", "Team Added Successfully..");
			return "addteam";
		} else {
			model.addAttribute("error", "Error creating team.Please try again..");
			return "addteam";
		}

	}

	public String getAllTeams(Model model) {

		List<Team> teams = teamDao.findAll();
		model.addAttribute("teams", teams);
		return "allteams";
	}



	public String getTeamByName(String name, Model model) {

		List<Team> teams = teamDao.getTeamsByPattern(name);
		if (teams != null) {
			model.addAttribute("teams", teams);
			return "teambyname";
		} else {
			model.addAttribute("error", "Team Not Found");
			return "teambyname";
		}
	}

	public String updateTeam(Team team, Model model) {

		Team team2 = teamDao.findById(team.getId());
		if (team2 != null) {
			team2.setName(team.getName());
			teamDao.updateTeam(team2, team.getId());
//			List<Team> teams = teamController.getAllTeams();
//			model.addAttribute("teams", teams);
			return "redirect:/api/teams/allteams";
		} else {
			model.addAttribute("error", "Team With Id " + team.getId() + " Not Found");
			return "updateteam";
		}

	}

	public String deleteTeam(Long id, Model model,RedirectAttributes redirectAttributes) {
		try {
			if (id != 0) {
				teamDao.deleteTeam(id);
				return "redirect:/api/teams/allteams";
			} else {
				model.addAttribute("error", "Team Id Cannot be zero.");
				return "redirect:/api/teams/allteams";
			}
			
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", "Cannot Delete Team. Team is Associated with a Match.");
			model.addAttribute("exception","Cannot Delete Team. Team is Present in Match." );
			return "redirect:/api/teams/allteams";
		}
	}
	
	public List<PlayerDetails> getPlayerDetailsByTeamId(Long id,Model model) {
			return teamDao.playersDetailsByTeam(id);
		
	}
}
