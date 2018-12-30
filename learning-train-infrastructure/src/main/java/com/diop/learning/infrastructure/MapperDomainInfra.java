package com.diop.learning.infrastructure;

import org.mapstruct.Mapper;

import com.diop.learning.train.domain.train.Train;
import com.diop.learning.train.infrastructure.mongodb.TrainMongo;

@Mapper(componentModel = "spring")
public interface MapperDomainInfra {
	public TrainMongo trainToTrainMongo(Train train);

	public Train trainMongoToTrain(TrainMongo trainMongo);

}