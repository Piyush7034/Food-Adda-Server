package com.infy.api;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.dto.RestaurantDTO;
import com.infy.service.RestaurantRecommendationService;

@CrossOrigin
@RestController
@RequestMapping("/recommendation-api")
public class RestaurantRecommendationAPI {

	@Autowired
	private RestaurantRecommendationService recommendationService;
	
	static Logger logger = LogManager.getLogger(RestaurantRecommendationAPI.class.getName());
	
	@GetMapping(value = "restaurant-list")
	public ResponseEntity<List<RestaurantDTO>> getRecommendationByArea(@PathVariable String area) throws Exception{
		logger.info("Fetch all restaurants in the given area!");
		List<RestaurantDTO> restaurantDTOList = recommendationService.getRecommendationByArea(area);
		
		return new ResponseEntity<>(restaurantDTOList, HttpStatus.OK);
	}
	
}
