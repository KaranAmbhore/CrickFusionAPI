package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.TeamDao;
import com.tka.entity.Player;
import com.tka.entity.Team;

@Service
public class TeamService {

	@Autowired
	private TeamDao teamDao;

	public Team createTeam(Team team) {
		return teamDao.save(team);
	}

	public Team getTeamById(Long id) {
		return teamDao.findById(id);

	}

	public List<Team> getAllTeams() {
		return teamDao.findAll();
	}

	public Object updateTeam(Team team, Long id) {

		return teamDao.updateTeam(team, id);
	}

	public String deleteTeam(Long id) {
		return teamDao.deleteTeam(id);
	}

	public Object getTeamByName(String name) {
		Team team = teamDao.getTeamByName(name);
		if (team != null) {
			return team;
		} else {
			return "Team Not Found.";

		}
	}

	public List<Team> getTeamsByPattern(String pattern) {
		List<Team> list = teamDao.getTeamsByPattern(pattern);
		if (list.isEmpty()) {
			return null;
		} else {
			return list;
		}
	}

	public List<Player> playersInTeam(Long id) {
	
		List<Player> players = teamDao.playersInTeam(id);
		if (!players.isEmpty()) {
			return players ;

		}else {
			return null;
		}
	}

	public Object playersInTeams(String name) {
		
		List<Player> list =  teamDao.playersInTeams(name);
		if(list != null) {
			return list;
		}else {
			return  "Team with name "+name+" not found..";
			
		}
	}
}
