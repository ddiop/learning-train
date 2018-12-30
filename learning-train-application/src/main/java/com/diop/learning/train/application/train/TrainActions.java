package com.diop.learning.train.application.train;

import java.util.List;
import java.util.Optional;

import com.diop.learning.domain.ddd.DDD;
import com.diop.learning.train.application.train.dto.TrainDTO;
import com.diop.learning.train.domain.train.Train;

@DDD.ApplicationService
public interface TrainActions {

	Optional<TrainDTO> getById(String id);

	void createTrain(Train train);

	List<TrainDTO> getAllTrain();
}
