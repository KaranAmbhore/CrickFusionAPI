package com.tka.entity;

public class Venue {

	private Long id;
	private String name;
	private String city;
	private int capacity;
	private String pitchCondition;
	
	public Venue() {
	}

	public Venue(Long id, String name, String city, int capacity, String pitchCondition) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.capacity = capacity;
		this.pitchCondition = pitchCondition;
	}

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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getPitchCondition() {
		return pitchCondition;
	}

	public void setPitchCondition(String pitchCondition) {
		this.pitchCondition = pitchCondition;
	}

	@Override
	public String toString() {
		return "Venue [id=" + id + ", name=" + name + ", city=" + city + ", capacity=" + capacity + ", pitchCondition="
				+ pitchCondition + "]";
	}
	
	
	
}
