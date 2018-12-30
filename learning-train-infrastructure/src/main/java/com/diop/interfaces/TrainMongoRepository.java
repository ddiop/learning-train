package com.diop.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diop.learning.train.infrastructure.mongodb.TrainMongo;



public interface TrainMongoRepository extends MongoRepository<TrainMongo, String> {

	

}
