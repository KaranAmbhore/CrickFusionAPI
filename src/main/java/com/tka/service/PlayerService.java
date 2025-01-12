package com.tka.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.tka.controller.TeamController;
import com.tka.dao.PlayerDao;
import com.tka.entity.Player;
import com.tka.entity.Team;

@Service
public class PlayerService {

    @Autowired
    private PlayerDao playerDao;
    
    @Autowired
    private TeamController teamController;

//    public Player createPlayer(Player player) {
//        return playerDao.save(player);
//    }
//   
//
//
    public Player getPlayerById(Long id) {
        return playerDao.findById(id);
               
    }
//
    public List<Player> getAllPlayers() {
        return playerDao.findAll();
    }
//
//	public Object updatePlayer(Player player, Long id) {
//		return playerDao.updatePlayer(player,id);
//	}
//	
//	
//
//	public String deletePlayer(Long id) {
//		return playerDao.deletePlayer(id);
//	}
//	
//	public Object getPlayerByName(String name) {
//		Player player = playerDao.getPlayerByName(name);
//		if (player != null) {
//			return player;
//		} else {
//			return "Player Not Found.";
//
//		}
//	}
//	
//	public List<Player> getPlayersByPattern(String pattern) {
//		List<Player> list = playerDao.getPlayersByPattern(pattern);
////		if(list.isEmpty()) {
////			return "Players Not Found";
////		}else {
//			return list;
//		
//	}
	
//	 Methods from userService....
//	
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

}
