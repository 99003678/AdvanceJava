package com.ltts.WebAppProject.model;

public class Auction {
private int auctionId;
private int teamId;
private int playerId;
private int amount;
private int year;






public Auction() {
	super();
}
public Auction(int auctionId, int teamId, int playerId, int amount, int year) {
	super();
	this.auctionId = auctionId;
	this.teamId = teamId;
	this.playerId = playerId;
	this.amount = amount;
	this.year = year;
}
public int getAuctionId() {
	return auctionId;
}
public void setAuctionId(int auctionId) {
	this.auctionId = auctionId;
}
public int getTeamId() {
	return teamId;
}
public void setTeamId(int teamId) {
	this.teamId = teamId;
}
public int getPlayerId() {
	return playerId;
}
public void setPlayerId(int playerId) {
	this.playerId = playerId;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
@Override
public String toString() {
	return "Auction [auctionId=" + auctionId + ", teamId=" + teamId + ", playerId=" + playerId + ", amount=" + amount
			+ ", year=" + year + "]";
}




}
