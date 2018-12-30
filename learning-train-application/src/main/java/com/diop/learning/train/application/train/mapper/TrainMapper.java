package com.diop.learning.train.application.train.mapper;

import org.mapstruct.Mapper;

import com.diop.learning.train.application.train.dto.TrainDTO;
import com.diop.learning.train.domain.train.Train;

@Mapper(componentModel = "spring")
public interface TrainMapper {
	public TrainDTO trainToTrainDTO(Train train);

	public Train trainDTOToTrain(TrainDTO trainDTO);

}
