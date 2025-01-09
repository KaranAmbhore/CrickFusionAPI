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

import com.tka.entity.Matches;
import com.tka.service.MatchService;

@RestController
@RequestMapping("/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @PostMapping
    public Matches createMatch(@RequestBody Matches matches) {
        return matchService.createMatch(matches);
    }

    @GetMapping("/{id}")
    public Matches getMatchById(@PathVariable Long id) {
        return matchService.getMatchById(id);
    }

    @GetMapping("all")
    public List<Matches> getAllMatches() {
        return matchService.getAllMatches();
    }
    
    @PutMapping("update/{id}")
    public Object updateMatch(@RequestBody Matches matches ,@PathVariable Long id) {
    	return matchService.updateMatch(matches,id);
    }
    
    @DeleteMapping("delete/{id}")
    public String deleteMatch(@PathVariable Long id) {
    	return matchService.deleteMatch(id);
    }
    
    @GetMapping("date/{date}")
    public Object getMatchesByName(@PathVariable String date) {
    	
    	return matchService.getMatchesByName(date);
    }
    
    @GetMapping("pattern/{pattern}")
    public Object getMatchessByPattern(@PathVariable String pattern) {
    	return matchService.getMatchessByPattern(pattern);
    }
    
    @GetMapping("byteam/{id}")
    public Object getMatchByTeam(@PathVariable("id") Long teamId) {
    	return matchService.getMatchByTeam(teamId);
    }
    
    @GetMapping("byname/{name}")
    public Object getMatchByTeamName(@PathVariable("name") String teamName) {
    	return matchService.getMatchByTeamName(teamName);
    }
    
    @GetMapping("venue/{venue}")
    public Object getMatchByVenue(@PathVariable String venue) {
    	return matchService.getMatchByVenue(venue);
    }
    
}
