package com.tka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tka.entity.Matches;
import com.tka.service.MatchService;

@Controller
@RequestMapping("api/matches")
public class MatchController {

	@Autowired
	private MatchService matchService;

//   

	@GetMapping("addmatch")
	public String addMatch() {
		return "addmatch";
	}

	@PostMapping("addmatchhandler")
	public String addMatch(@ModelAttribute Matches match, Model model) {
		System.out.println(match.getId());
		System.out.println(match.getLocation());
		System.err.println(match.getMatchDate());
		System.err.println(match.getTeam1());
		System.err.println(match.getTeam2());

		return matchService.addMatch(match, model);

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
	public String getMatchByName(@RequestParam(required = false) String input, Model model) {
		System.err.println(input);
		model.addAttribute("input", input);
		return matchService.getMatchByVenue(input, model);
	}
//	
//	@PostMapping("matchbydate")
//	public String getMatchByName(@RequestParam(required = false) String matchDate,Model model) {
//		return matchService.getMatchByName(matchDate,model);
//	}

	@PostMapping("matchupdateid")
	public String getMatchUpdateId(@RequestParam Long id, Model model) {
		Matches match = matchService.getMatchById(id);
		model.addAttribute("match", match);
		return "updatematch";

	}

	@PostMapping("updatematchhandler")
	public String updateMatch(@ModelAttribute Matches match, Model model) {
		return matchService.updateMatch(match, model);
	}

	@PostMapping("deletematchhandler")
	public String deleteMatch(@RequestParam Long id, Model model) {
		return matchService.deleteMatch(id, model);
	}

	@GetMapping("match-image")
	public String getMatchSchedule(Model model) {
		System.out.println("Inside match with image api");
		return matchService.getAllMatches(model);
	}

}
