package com.ltts.WebAppProject.model;

import java.time.LocalDate;
import java.sql.Date;

public class Player {
   
	private int playerId;
	private String playerName;
	private Date dateOfBirth;
	private String skills;
	private int teamId;
	private int numberOfMatches;
	private int wickets;
	private String Nationality;
	private int runs;
	
	
	public Player() {
		super();
	}
	
	public Player(int playerId, String playerName, Date dateOfBirth, String skills, int teamId,
			int numberOfMatches, int wickets, String nationality, int runs) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.dateOfBirth = dateOfBirth;
		this.skills = skills;
		this.teamId = teamId;
		this.numberOfMatches = numberOfMatches;
		this.wickets = wickets;
		Nationality = nationality;
		this.runs = runs;
	}
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public int getNumberOfMatches() {
		return numberOfMatches;
	}
	public void setNumberOfMatches(int numberOfMatches) {
		this.numberOfMatches = numberOfMatches;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public String getNationality() {
		return Nationality;
	}
	public void setNationality(String nationality) {
		Nationality = nationality;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}



	
	
}