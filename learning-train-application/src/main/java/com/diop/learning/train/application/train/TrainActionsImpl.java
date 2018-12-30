package com.diop.learning.train.application.train;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diop.learning.domain.ddd.DDD;
import com.diop.learning.train.application.train.dto.TrainDTO;
import com.diop.learning.train.application.train.mapper.TrainMapper;
import com.diop.learning.train.domain.train.Train;
import com.diop.learning.train.domain.train.TrainService;

@DDD.ApplicationService
@Service
public class TrainActionsImpl implements TrainActions {
	
	private  TrainService trainService;
	private  TrainMapper trainMapper;

	
	

	

	public TrainActionsImpl(TrainService trainService, TrainMapper trainMapper) {
		super();
		this.trainService = trainService;
		this.trainMapper = trainMapper;
	}


	public Optional<TrainDTO> getById(String id) {
		// TODO Auto-generated method stub
		return Optional.of(trainMapper.trainToTrainDTO(trainService.findById(id).get()));
	}


	public void createTrain(Train train) {
		trainService.saveTrain(train);
	}


	public List<TrainDTO> getAllTrain() {
		// TODO Auto-generated method stub
		return trainService.findAll().stream().map(train->trainMapper.trainToTrainDTO(train)).collect(Collectors.toList());
	}

	
}
