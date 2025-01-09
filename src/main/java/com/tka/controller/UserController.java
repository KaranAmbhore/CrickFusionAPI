package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tka.entity.Matches;
import com.tka.entity.Player;
import com.tka.entity.Team;
import com.tka.entity.User;
import com.tka.service.UserService;

@Controller
@RequestMapping("api/ipl/user")
public class UserController {

	@Autowired
	PlayerController playerController;
	
	@Autowired
	private UserService userService;

	@Autowired
	private TeamController teamController;
	
	@Autowired
	private MatchController matchController;
	
	
	User user = new User();

	@GetMapping("/")
	public String loginPage() {
		return "login";
	}

	@PostMapping("loginhandle")
	public String loginHandler(@ModelAttribute User user,Model model) {
		boolean correct = userService.loginHandler(user);
		if (correct) {
			
			model.addAttribute("name", user.getUsername());
			return "choose";
		}else {
			model.addAttribute("error", "Invalid Username or Password");
			return "login";
		}
	}
	
	@GetMapping("choice")
	public String chooseOperation() {
		
		return "choose";
	}
	
	@GetMapping("all")
	public String getAllPlayers(Model model) {
		
		List<Player> players = playerController.getAllPlayers();
		model.addAttribute("players", players);
		return "allplayers";
//		return "demoplayers";
	}
	
	@GetMapping("byid")
	public String getPlayerByName() {
		return "playerbyname";
	}
	
	@PostMapping("playerbyname")
	public String getPlayerByName(@RequestParam String name,  Model model) {
		return userService.getPlayerByName(name, model);
	}
	
	@GetMapping("register")
	public String addPlayerPage() {
		return "register";
	}
	
	
	@PostMapping("handleregister")
	public String addPlayer(@ModelAttribute Player player,Model model) {
		System.out.println(player.getName());
		System.out.println(player.getAge());
		System.out.println(player.getTeam().getId());
		System.out.println(player.getTeam().getName());
		return userService.addPlayer(player,model);
	}
	
	@GetMapping("update")
	public String updatePage() {
		return "update";
	}
	
	@PostMapping("getupdateid")
	public String getUpateId(@RequestParam Long id,Model model) {
		Player player = playerController.getPlayerById(id);
		model.addAttribute("player", player);
		return "update";
		
	}
	
	@PostMapping("updateplayer")
	public String updatePlayer(@ModelAttribute Player player,Model model) {
		return userService.updatePlayer(player,model);
	}
	
	@GetMapping("delete")
	public String getDeletePage() {
		return "delete";
	}
	
	@PostMapping("deleteid")
	public String getDeleteId(@RequestParam Long id, Model model) {
		model.addAttribute("id", id);
		return "delete";
	}
	
	
	@PostMapping("deletehandler")
	public String deletePlayer(@RequestParam Long id, Model model) {
		System.out.println("ID is present :"+id);
			return userService.deletePlayer(id,model);	
	}
	
	
	@GetMapping("team")
	public String addTeam() {
		return "addteam";
	}
	
	@PostMapping("addteam")
	public String addTeam(@ModelAttribute Team team, Model model) {
		return userService.addTeam(team,model);
	}
	
	@GetMapping("allteams")
	public String getAllTeams(Model model) {
		return userService.getAllTeams(model);
	}
	
	@GetMapping("playersbyteam")
	public String getTeamById() {
		return "playersbyteamid";
	}
	
	@PostMapping("getteamid")
	public String getTeamID(@RequestParam Long id,Model model) {
		
		List<Player> players =  teamController.playersInTeam(id);
		model.addAttribute("players", players);
		return "playersbyteamid";
	}
	
	@GetMapping("teambyname")
	public String getTeamByName() {
		return "teambyname";
	}
	
	@PostMapping("teambynamehandler")
	public String getTeamByName(@RequestParam String name,Model model) {
		return userService.getTeamByName(name,model);
	}
	
	
	
	@GetMapping("updateteam")
	public String updateTeamPage() {
		return "updateteam";
	}
	
	@PostMapping("getupdateteamid")
	public String getUpateTeamId(@RequestParam Long id, Model model) {
		Team team = teamController.getTeamById(id);
		model.addAttribute("team", team);
		return "updateteam";
	}
	
	@PostMapping("updateteamhandler")
	public String updateTeam(@ModelAttribute Team team , Model model) {
		return userService.updateTeam(team,model);
	}
	
	@PostMapping("deleteteamhandler")
	public String deleteTeamById(@RequestParam Long id,Model model) {
		return userService.deleteTeam(id,model);
	}
	
	
	@GetMapping("addmatch")
	public String addMatch() {
		return "addmatch";
	}
	
	@PostMapping("addmatchhandler")
	public String addMatch(@ModelAttribute Matches match,Model model) {
	System.out.println(match.getId());
	System.out.println(match.getLocation());
	System.err.println(match.getMatchDate());
	System.err.println(match.getTeam1());
	System.err.println(match.getTeam2());
	
		return userService.addMatch(match,model);
		
	}
	
	@GetMapping("allmatches")
	public String getAllMatches(Model model) {
		
		return userService.getAllMatches(model);
	}
	
	@GetMapping("getmatch")
	public String getMatch() {
		return "getmatch";
	}
	
	@PostMapping("searchmatch")
	public String getMatchByName(@RequestParam(required = false) String input,Model model) {
		System.err.println(input);
		return userService.getMatchByVenue(input,model);
	}
//	
//	@PostMapping("matchbydate")
//	public String getMatchByName(@RequestParam(required = false) String matchDate,Model model) {
//		return userService.getMatchByName(matchDate,model);
//	}
	
	@PostMapping("matchupdateid")
	public String getMatchUpdateId(@RequestParam Long id,Model model) {
		Matches match = matchController.getMatchById(id);
		model.addAttribute("match", match);
		return "updatematch";
		
	}
	
	@PostMapping("updatematchhandler")
	public String updateMatch(@ModelAttribute Matches match,Model model) {
		return userService.updateMatch(match,model);
	}
	
	@PostMapping("deletematchhandler")
	public String deleteMatch(@RequestParam Long id,Model model) {
		return userService.deleteMatch(id,model);
	}
}
