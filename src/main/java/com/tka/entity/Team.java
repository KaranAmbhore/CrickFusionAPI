package com.tka.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Player> players;

    private String teamLogo;
    
    public Team() {
		// TODO Auto-generated constructor stub
	}
   

	public Team(Long id, String name, List<Player> players, String teamLogo) {
		super();
		this.id = id;
		this.name = name;
		this.players = players;
		this.teamLogo = teamLogo;
	}

	
	
	
	public String getTeamLogo() {
		return teamLogo;
	}




	public void setTeamLogo(String teamLogo) {
		this.teamLogo = teamLogo;
	}




	// Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", players=" + players + ", teamLogo=" + teamLogo + "]";
	}
    
    
}
