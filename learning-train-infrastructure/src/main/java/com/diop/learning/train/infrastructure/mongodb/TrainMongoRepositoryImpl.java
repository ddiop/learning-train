package com.diop.learning.train.infrastructure.mongodb;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.diop.interfaces.TrainMongoRepository;
import com.diop.learning.domain.ddd.DDD;
import com.diop.learning.infrastructure.MapperDomainInfra;
import com.diop.learning.train.domain.train.Train;
import com.diop.learning.train.domain.train.TrainRepository;

@DDD.RepositoryImpl
@Repository
public class TrainMongoRepositoryImpl implements TrainRepository {
	@Autowired
	private MongoTemplate mongoTemplate;
//	@Autowired
//	private org.dozer.Mapper mapper;
	@Autowired
	MapperDomainInfra mapper;
	@Autowired
	private TrainMongoRepository trainmongoRepository;

	public TrainMongoRepositoryImpl() {

	}


	

//	// @Autowired(required = true)
//	public TrainMongoRepositoryImpl(MongoTemplate mongoTemplate, Mapper mapper) {
//		super();
//		this.mongoTemplate = mongoTemplate;
//		this.mapper = mapper;
//		saveTrain(null);
//	}

	public Optional<Train> findOne(String id) {
		// TrainMongo tr = mapper.map(new Train(), TrainMongo.class);
		// return Optional.of(mapper.map(mongoTemplate.findById(id,
		// TrainMongo.class),Train.class));
		return Optional.of(mapper.trainMongoToTrain(trainmongoRepository.findOne(id)));
	}

	public void saveTrain(Train train) {
		// TrainMongo tr = mapper.map(new Train(), TrainMongo.class);
		trainmongoRepository.save(mapper.trainToTrainMongo(train));
	}

	public List<Train> findAll() {
		// TODO Auto-generated method stub
		return trainmongoRepository.findAll().stream().map(mapper::trainMongoToTrain)
				.collect(Collectors.toList());
	}

}