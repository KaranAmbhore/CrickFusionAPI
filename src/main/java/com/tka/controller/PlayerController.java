package com.tka.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tka.entity.Player;
import com.tka.service.PlayerService;

@Controller
@RequestMapping("api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

//    @PostMapping
//    public Player createPlayer(@RequestBody Player player) {
//        return playerService.createPlayer(player);
//    }
//
//    @GetMapping("/{id}")
//    public Player getPlayerById(@PathVariable Long id) {
//        return playerService.getPlayerById(id);
//    }
//
//    @GetMapping("all")
//    public List<Player> getAllPlayers() {
//        return playerService.getAllPlayers();
//    }
//    
//    @PutMapping("update/{id}")
//    public Object updatePlayer(@RequestBody Player player, @PathVariable Long id) {
//    	
//    	return playerService.updatePlayer(player,id);
//    }
//    
//    @DeleteMapping("delete/{id}")
//    public String deletePlayer(@PathVariable Long id) {
//    	return playerService.deletePlayer(id);
//    }
//    
//    @GetMapping("name/{name}")
//    public Object getPlayerByName(@PathVariable String name) {
//    	
//    	return playerService.getPlayerByName(name);
//    }
//    
//    @GetMapping("pattern/{pattern}")
//    public List<Player> getPlayersByPattern(@PathVariable String pattern) {
//    	return playerService.getPlayersByPattern(pattern);
//    }
    
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
	
    
}
