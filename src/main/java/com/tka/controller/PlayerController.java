package com.tka.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Player;
import com.tka.service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id);
    }

    @GetMapping("all")
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }
    
    @PutMapping("update/{id}")
    public Object updatePlayer(@RequestBody Player player, @PathVariable Long id) {
    	
    	return playerService.updatePlayer(player,id);
    }
    
    @DeleteMapping("delete/{id}")
    public String deletePlayer(@PathVariable Long id) {
    	return playerService.deletePlayer(id);
    }
    
    @GetMapping("name/{name}")
    public Object getPlayerByName(@PathVariable String name) {
    	
    	return playerService.getPlayerByName(name);
    }
    
    @GetMapping("pattern/{pattern}")
    public List<Player> getPlayersByPattern(@PathVariable String pattern) {
    	return playerService.getPlayersByPattern(pattern);
    }
    
}
