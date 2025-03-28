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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tka.entity.Player;
import com.tka.entity.PlayerDetails;
import com.tka.service.PlayerService;

@Controller
@RequestMapping("api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    
    
    
    // Methods from user controller...
    
	@GetMapping("all")
	public String getAllPlayers(Model model) {
		
		List<Player> players = playerService.getAllPlayers();
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
		return playerService.getPlayerByName(name, model);
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
		return playerService.createPlayer(player,model);
	}
	
	@GetMapping("update")
	public String updatePage() {
		return "update";
	}
	
	@PostMapping("getupdateid")
	public String getUpateId(@RequestParam Long id,Model model) {
		System.err.println("Update player Id >>>"+id);
		Player player = playerService.getPlayerById(id);
		model.addAttribute("player", player);
		return "update";
		
	}
	
	@PostMapping("updateplayer")
	public String updatePlayer(@ModelAttribute Player player,Model model) {
		return playerService.updatePlayer(player,model);
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
			return playerService.deletePlayer(id,model);	
	}
	
	@GetMapping("playerdetails")
    public String getAllPlayersDetails(Model model) {
    	List<PlayerDetails>players = playerService.getAllPlayerDetails();
    	model.addAttribute("players", players);
    	return "playerdetails";
    }
	
	@PostMapping("getupdateplayerid")
	public String getUpatePlayerId(@RequestParam Long id,Model model) {
		System.err.println("Update player Id >>>"+id);
		PlayerDetails player = playerService.getPlayerDetailsById(id);
		System.err.println(player);
		model.addAttribute("player", player);
		return "updateplayer";
		
	}
	
	@PostMapping("updateplayerhandler")
	public String updatePlayerDetails(@ModelAttribute PlayerDetails player,Model model) {
		return playerService.updatePlayerDetails(player,model);
	}
	

	@GetMapping("addnewplayer")
	public String addNewPlayer() {
		return "addnewplayer";
	}
	
	@PostMapping("addnewplayerhandler")
	public String addNewPlayer(@ModelAttribute PlayerDetails player,Model model) {
		System.err.println(player);
		return playerService.addNewPlayerDetails(player,model);
	}
	
	@PostMapping("deleteplayerhandler")
	public String deletePlayerHandler(@RequestParam Long id,RedirectAttributes redirectAttributes) {
		System.out.println("Player ID To delete :: "+id);
		return playerService.deletePlayerDetails(id,redirectAttributes);
	}
	@GetMapping("playerdetailsbyname")
	public String getPlayerDetailsByName(@RequestParam String name,  Model model) {
		System.err.println("Player Name From detail page ::"+name);
		String playerName = name.trim();
		System.err.println("Player Name From detail After trim ::"+playerName);
		model.addAttribute("playername", playerName);
		return playerService.getPlayerDetailsByName(name, model);
	}
}
