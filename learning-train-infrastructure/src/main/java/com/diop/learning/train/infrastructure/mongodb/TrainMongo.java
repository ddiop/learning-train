package com.diop.learning.train.infrastructure.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="train")
@TypeAlias("train")
public class TrainMongo {
	 @Id
	@Field("trainId")
	private String id;
	private int capacity = 0;
	private int carsInTrain;
	private int distanceToStation;

	
	public TrainMongo() {
		super();
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
