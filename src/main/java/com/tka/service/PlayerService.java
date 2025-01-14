package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tka.controller.TeamController;
import com.tka.dao.PlayerDao;
import com.tka.entity.Player;
import com.tka.entity.PlayerDetails;
import com.tka.entity.Team;

@Service
public class PlayerService {

	@Autowired
	private PlayerDao playerDao;

	@Autowired
	private TeamController teamController;

	public Player getPlayerById(Long id) {
		return playerDao.findById(id);

	}

//
	public List<Player> getAllPlayers() {
		return playerDao.findAll();
	}
	public String createPlayer(Player player, Model model) {

		Team team = teamController.getTeamById(player.getTeam().getId());

		if (player != null && team != null) {
			playerDao.save(player);
			model.addAttribute("message", "Player Added Successfully...");
			return "register";
		} else {
			model.addAttribute("error", "Cannot add Player.No team with Id " + player.getTeam().getId() + " found.");
			model.addAttribute("name", player.getName());
			model.addAttribute("age", player.getAge());
			model.addAttribute("teamid", player.getTeam().getId());
			return "register";
		}

	}

	public String getPlayerByName(String name, Model model) {

		List<Player> players = playerDao.getPlayersByPattern(name);
		System.err.println(players);
		if (!players.isEmpty()) {
			model.addAttribute("players", players);
			return "playerbyname";
		} else {
			model.addAttribute("error", "Player Not found");
			return "playerbyname";
		}

	}

	public String updatePlayer(Player player, Model model) {

		Player player2 = playerDao.findById(player.getId());
		if (player2 != null) {
			player2.setAge(player.getAge());
			player2.setName(player.getName());
			player2.setTeam(player.getTeam());
			playerDao.updatePlayer(player2, player.getId());
//			List<Player> players = playerController.getAllPlayers();
//			model.addAttribute("players", players);
			return "redirect:/api/players/all";
		} else {
			model.addAttribute("error", "Cannot update player details right now..");
			return "update";
		}

	}

	public String deletePlayer(Long id, Model model) {
		if (id != 0) {
			playerDao.deletePlayer(id);
			List<Player> players = playerDao.findAll();
			model.addAttribute("players", players);
			return "redirect:/api/players/all";
//			return "demoplayers";
		} else {
			model.addAttribute("error", "Player Not Found");
			return "delete";
		}

	}

	public List<PlayerDetails> getAllPlayerDetails() {

		return playerDao.getAllPlayerDetails();
	}

	public PlayerDetails getPlayerDetailsById(Long id) {
		return playerDao.getPlayerDetailsById(id);

	}

	public String updatePlayerDetails(PlayerDetails player, Model model) {

		PlayerDetails player2 = playerDao.getPlayerDetailsById(player.getPlayerId());
		if (player2 != null) {

			playerDao.updatePlayerDetails(player, model);
			return "redirect:/api/players/playerdetails";
		} else {
			model.addAttribute("error", "Cannot update player details right now..");
			return "updateplayer";
		}

	}

	public String addNewPlayerDetails(PlayerDetails player, Model model) {

		if (player != null) {
			model.addAttribute("success", "Player Added Successfully");
			return playerDao.addNewPlayerDetails(player);
		} else {
			model.addAttribute("error", "Cannot add player.Something went wrong..");
			return null;
		}
	}

	public String deletePlayerDetails(Long id, RedirectAttributes redirectAttributes) {

		PlayerDetails player = playerDao.getPlayerDetailsById(id);

		if (id > 0 && player != null) {
			return playerDao.deletePlayerDetails(id, redirectAttributes);
		} else {
			redirectAttributes.addFlashAttribute("error", "Invalid Id.Please provide correct Id ");
			return "redirect:/api/player/playerdetails";
		}

	}

	public String getPlayerDetailsByName(String name, Model model) {
		List<PlayerDetails> players = playerDao.getPlayerDetailsByName(name);
		if (players != null && !players.isEmpty()) {
			model.addAttribute("players", players);
			return "playerdetails";
		} else {
			model.addAttribute("availablenot", "Player Not Found");
			return "playerdetails";

		}

	}

}