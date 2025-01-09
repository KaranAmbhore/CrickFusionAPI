package com.tka.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    @JsonBackReference
    private Team team;

    public Player() {

    }
    
    
    public Player(Long id, String name, int age, Team team) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.team = team;
	}
//    public Player( String name, int age) {
//    	super();
//    
//    	this.name = name;
//    	this.age = age;
//    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", age=" + age+ "]";
	}

//	@Override
//	public String toString() {
//		return "Player [  name=" + name + ", age=" + age +  "]";
//	}
    
    
}
