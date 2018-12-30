package com.diop.learning.train.exposition.train.web.rest;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diop.learning.train.application.train.TrainActions;
import com.diop.learning.train.application.train.dto.TrainDTO;
import com.diop.learning.train.domain.train.Train;

@RestController
@RequestMapping("/api")
public class TrainResource {
	private static final Logger LOGGER = LoggerFactory.getLogger(TrainResource.class);
	
	private TrainActions trainService;


	public TrainResource(TrainActions trainService) {
	
		this.trainService = trainService;
	}

	
	@PostMapping(path = "/trains", consumes = "application/json")
	public void createTrain(@RequestBody @Valid Train train,ServletRequest request) {
		LOGGER.debug("Begin POST:/property-loan/property-loan-requests with body {}", train);
		trainService.createTrain(train);
		return  ;
	}
	@RequestMapping(value = "/trains/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TrainDTO> getTrainById(@PathVariable String id, ServletRequest request) {
		LOGGER.debug("Begin GET:/property-loan/property-loan-requests/{}", id);
		TrainDTO result = trainService.getById(id).get();
		return ResponseEntity.ok().body(result);
	}

	@RequestMapping(value = "/trains", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TrainDTO>> getAllTrains(ServletRequest request) {
		LOGGER.debug("Begin GET:/property-loan/property-loan-requests/{}");
		return ResponseEntity.ok().body(trainService.getAllTrain());
	}
}
