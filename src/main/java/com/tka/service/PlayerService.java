package com.tka.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.PlayerDao;
import com.tka.entity.Player;
import com.tka.entity.Team;

@Service
public class PlayerService {

    @Autowired
    private PlayerDao playerDao;

    public Player createPlayer(Player player) {
        return playerDao.save(player);
    }

    public Player getPlayerById(Long id) {
        return playerDao.findById(id);
               
    }

    public List<Player> getAllPlayers() {
        return playerDao.findAll();
    }

	public Object updatePlayer(Player player, Long id) {
		return playerDao.updatePlayer(player,id);
	}

	public String deletePlayer(Long id) {
		return playerDao.deletePlayer(id);
	}
	
	public Object getPlayerByName(String name) {
		Player player = playerDao.getPlayerByName(name);
		if (player != null) {
			return player;
		} else {
			return "Player Not Found.";

		}
	}
	
	public List<Player> getPlayersByPattern(String pattern) {
		List<Player> list = playerDao.getPlayersByPattern(pattern);
//		if(list.isEmpty()) {
//			return "Players Not Found";
//		}else {
			return list;
		
	}
}
