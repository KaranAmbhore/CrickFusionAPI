package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tka.entity.Player;
import com.tka.entity.Team;
import com.tka.service.TeamService;

@Controller
@RequestMapping("api/teams")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@GetMapping("/{id}")
	public Team getTeamById(@PathVariable Long id) {
		return teamService.getTeamById(id);
	}
//

	@GetMapping("team")
	public String addTeam() {
		return "addteam";
	}

	@PostMapping("addteam")
	public String addTeam(@ModelAttribute Team team, Model model) {
		return teamService.addTeam(team, model);
	}

	@GetMapping("allteams")
	public String getAllTeams(Model model) {
		return teamService.getAllTeams(model);
	}

	@GetMapping("playersbyteam")
	public String getTeamById() {
		return "playersbyteamid";
	}

	@PostMapping("getteamid")
	public String getTeamID(@RequestParam Long id, Model model) {

		List<Player> players = teamService.playersInTeam(id);
		model.addAttribute("players", players);
		return "playersbyteamid";
	}

	@GetMapping("teambyname")
	public String getTeamByName() {
		return "teambyname";
	}

	@PostMapping("teambynamehandler")
	public String getTeamByName(@RequestParam String name, Model model) {
		return teamService.getTeamByName(name, model);
	}

	@GetMapping("updateteam")
	public String updateTeamPage() {
		return "updateteam";
	}

	@PostMapping("getupdateteamid")
	public String getUpateTeamId(@RequestParam Long id, Model model) {
		Team team = teamService.getTeamById(id);
		model.addAttribute("team", team);
		return "updateteam";
	}

	@PostMapping("updateteamhandler")
	public String updateTeam(@ModelAttribute Team team, Model model) {
		return teamService.updateTeam(team, model);
	}

	@PostMapping("deleteteamhandler")
	public String deleteTeamById(@RequestParam Long id, Model model, RedirectAttributes redirectAttributes) {
		return teamService.deleteTeam(id, model, redirectAttributes);
	}

}
