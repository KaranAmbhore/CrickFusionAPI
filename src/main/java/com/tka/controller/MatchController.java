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
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Matches;
import com.tka.service.MatchService;

@Controller
@RequestMapping("api/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

//    @PostMapping
//    public Matches createMatch(@RequestBody Matches matches) {
//        return matchService.createMatch(matches);
//    }
//
//    @GetMapping("/{id}")
//    public Matches getMatchById(@PathVariable Long id) {
//        return matchService.getMatchById(id);
//    }
//
//    @GetMapping("all")
//    public List<Matches> getAllMatches() {
//        return matchService.getAllMatches();
//    }
//    
//    @PutMapping("update/{id}")
//    public Object updateMatch(@RequestBody Matches matches ,@PathVariable Long id) {
//    	return matchService.updateMatch(matches,id);
//    }
//    
//    @DeleteMapping("delete/{id}")
//    public String deleteMatch(@PathVariable Long id) {
//    	return matchService.deleteMatch(id);
//    }
//    
//    @GetMapping("date/{date}")
//    public Object getMatchesByName(@PathVariable String date) {
//    	
//    	return matchService.getMatchesByName(date);
//    }
//    
//    @GetMapping("pattern/{pattern}")
//    public Object getMatchessByPattern(@PathVariable String pattern) {
//    	return matchService.getMatchessByPattern(pattern);
//    }
//    
//    @GetMapping("byteam/{id}")
//    public Object getMatchByTeam(@PathVariable("id") Long teamId) {
//    	return matchService.getMatchByTeam(teamId);
//    }
//    
//    @GetMapping("byname/{name}")
//    public Object getMatchByTeamName(@PathVariable("name") String teamName) {
//    	return matchService.getMatchByTeamName(teamName);
//    }
//    
//    @GetMapping("venue/{venue}")
//    public Object getMatchByVenue(@PathVariable String venue) {
//    	return matchService.getMatchByVenue(venue);
//    }
    
//    Matches API from user Controller....
    
	
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
	
		return matchService.addMatch(match,model);
		
	}
	
	@GetMapping("allmatches")
	public String getAllMatches(Model model) {
		
		return matchService.getAllMatches(model);
	}
	
	@GetMapping("getmatch")
	public String getMatch() {
		return "getmatch";
	}
	
	@PostMapping("searchmatch")
	public String getMatchByName(@RequestParam(required = false) String input,Model model) {
		System.err.println(input);
		model.addAttribute("input", input);
		return matchService.getMatchByVenue(input,model);
	}
//	
//	@PostMapping("matchbydate")
//	public String getMatchByName(@RequestParam(required = false) String matchDate,Model model) {
//		return matchService.getMatchByName(matchDate,model);
//	}
	
	@PostMapping("matchupdateid")
	public String getMatchUpdateId(@RequestParam Long id,Model model) {
		Matches match = matchService.getMatchById(id);
		model.addAttribute("match", match);
		return "updatematch";
		
	}
	
	@PostMapping("updatematchhandler")
	public String updateMatch(@ModelAttribute Matches match,Model model) {
		return matchService.updateMatch(match,model);
	}
	
	@PostMapping("deletematchhandler")
	public String deleteMatch(@RequestParam Long id,Model model) {
		return matchService.deleteMatch(id,model);
	}
    
}
