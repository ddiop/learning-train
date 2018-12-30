package com.diop.learning.train.domain.train;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TrainServiceImpl implements TrainService{
	private final TrainRepository trainRepository;
	
	public TrainServiceImpl(TrainRepository trainRepository) {
		
		this.trainRepository = trainRepository;
	}

	
	public Optional<Train> findById(String id) {
		// TODO Auto-generated method stub
		return trainRepository.findOne(id);
	}

	
	public void saveTrain(Train train) {
		// TODO Auto-generated method stub
		trainRepository.saveTrain(train);
	}

	
	public List<Train> findAll() {
		// TODO Auto-generated method stub
		return trainRepository.findAll();
	}

	
	

}