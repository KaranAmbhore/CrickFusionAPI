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
import com.tka.entity.Team;
import com.tka.service.TeamService;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamService.createTeam(team);
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable Long id) {
        return teamService.getTeamById(id);
    }

    @GetMapping("all")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }
    
    @PutMapping("update/{id}")
    public Object updateTeam(@RequestBody Team team ,@PathVariable Long id) {
    	
    	return teamService.updateTeam(team,id);
    }
    
    @DeleteMapping("delete/{id}")
    public String deleteTeam(@PathVariable Long id) {
    	
    	return teamService.deleteTeam(id);
    }
    
    @GetMapping("name/{name}")
    public Object getTeamByName(@PathVariable String name) {
    	
    	return teamService.getTeamByName(name);
    }
    
    @GetMapping("pattern/{pattern}")
    public List<Team> getTeamsByPattern(@PathVariable String pattern) {
    	return teamService.getTeamsByPattern(pattern);
    }
    
    
    @GetMapping("teamplr/{id}")
    public List<Player> playersInTeam(@PathVariable Long id) {
    	return teamService.playersInTeam(id);
    }
    
    @GetMapping("teamplrs/{name}")
    public Object playerInTeams(@PathVariable String name) {
    	return teamService.playersInTeams(name);
    }
}
