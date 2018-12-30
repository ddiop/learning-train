package com.diop.learning.train.domain.train;

import java.util.List;
import java.util.Optional;

import com.diop.learning.domain.ddd.DDD;

@DDD.Repository
public interface TrainRepository {
	Optional<Train> findOne(String id);

	void saveTrain(Train train);

	List<Train> findAll();
}
