package com.tka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class PlayerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long playerId;
	private String playerName;
	private int age;
	private int totalRuns;
	private int totalCenturies;
	private double strikeRate;
	private String playerRole;
	private int wickets;
	private double economy;
	private String playerImage;

	@ManyToOne
	@JoinColumn(name = "team_id", nullable = false)
	@JsonBackReference
	private Team team;

	public PlayerDetails() {

	}

	public PlayerDetails(Long playerId, String playerName, int age, int totalRuns, int totalCenturies,
			double strikeRate, String playerRole, int wickets, double economy, String playerImage, Team team) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.age = age;
		this.totalRuns = totalRuns;
		this.totalCenturies = totalCenturies;
		this.strikeRate = strikeRate;
		this.playerRole = playerRole;
		this.wickets = wickets;
		this.economy = economy;
		this.playerImage = playerImage;
		this.team = team;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTotalRuns() {
		return totalRuns;
	}

	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}

	public int getTotalCenturies() {
		return totalCenturies;
	}

	public void setTotalCenturies(int totalCenturies) {
		this.totalCenturies = totalCenturies;
	}

	public double getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
	}

	public String getPlayerRole() {
		return playerRole;
	}

	public void setPlayerRole(String playerRole) {
		this.playerRole = playerRole;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public int getWickets() {
		return wickets;
	}

	public void setWickets(int wickets) {
		this.wickets = wickets;
	}

	public double getEconomy() {
		return economy;
	}

	public void setEconomy(double economy) {
		this.economy = economy;
	}

	public String getPlayerImage() {
		return playerImage;
	}

	public void setPlayerImage(String playerImage) {
		this.playerImage = playerImage;
	}

	@Override
	public String toString() {
		return "PlayerDetails [playerId=" + playerId + ", playerName=" + playerName + ", age=" + age + ", totalRuns="
				+ totalRuns + ", totalCenturies=" + totalCenturies + ", strikeRate=" + strikeRate + ", playerRole="
				+ playerRole + ", wickets=" + wickets + ", economy=" + economy + ", playerImage=" + playerImage + "]";
	}

}
