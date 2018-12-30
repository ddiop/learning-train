package com.diop.learning.train.application.train.dto;

public class TrainDTO {
	private String id;
	private int capacity = 0;
	private int carsInTrain;
	private int distanceToStation;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getCarsInTrain() {
		return carsInTrain;
	}
	public void setCarsInTrain(int carsInTrain) {
		this.carsInTrain = carsInTrain;
	}
	public int getDistanceToStation() {
		return distanceToStation;
	}
	public void setDistanceToStation(int distanceToStation) {
		this.distanceToStation = distanceToStation;
	}

}
