package com.infy.api;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.infy.dto.DishDTO;
import com.infy.dto.RestaurantDTO;
import com.infy.service.RestaurantRegisterService;


@CrossOrigin
@RestController
@RequestMapping("/restaurant-register-api")
public class RestaurantRegisterAPI {

	@Autowired
	private RestaurantRegisterService restaurantRegisterService;
	
	@Autowired
	private Environment environment;
	
	static Logger logger = LogManager.getLogger(RestaurantRegisterAPI.class.getName());
	

	@PostMapping(value = "/register-restaurant/{userId}")
	public ResponseEntity<Integer> registerRestaurant(@RequestBody @Valid RestaurantDTO restaurant, 
													  @PathVariable Integer userId) throws Exception {
		logger.info("Register a new restaurant!");
		Integer response = restaurantRegisterService.registerNewRestaurant(restaurant, userId);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	

	@GetMapping(value = "restaurant-list/{userId}")
	public ResponseEntity<List<RestaurantDTO>> viewRestaurantDetails(@PathVariable Integer userId) throws Exception{
		logger.info("View Restaurant List Details!");
		List<RestaurantDTO> restaurantDTOList = restaurantRegisterService.viewRestaurants(userId);
		
		return new ResponseEntity<>(restaurantDTOList, HttpStatus.OK);
	}
	
	@GetMapping(value = "dish-list/{restaurantId}")
	public ResponseEntity<List<DishDTO>> viewDishDetails(@PathVariable Integer restaurantId) throws Exception{
		logger.info("View Dish List Details!");
		List<DishDTO> dishDTOList = restaurantRegisterService.viewDishes(restaurantId);
		
		return new ResponseEntity<>(dishDTOList, HttpStatus.OK);	
	}
	
	@PutMapping(value = "update-dish/{restaurantId}")
	public ResponseEntity<String> updateDish(@RequestBody @Valid DishDTO dish, @PathVariable Integer restaurantId) throws Exception {
		logger.info("Update dish for given restaurant id!");
		Integer id = restaurantRegisterService.updateDish(dish, restaurantId);
		String response = environment.getProperty("RestaurantRegisterAPI.DISH_DETAILS_UPDATED") + " Dish Id: " + id;
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "add-dish/{restaurantId}")
	public ResponseEntity<String> addDish(@PathVariable Integer restaurantId, @RequestBody @Valid DishDTO dish) throws Exception {
		logger.info("Add given dish to the given restaurant!");
		Integer id = restaurantRegisterService.addDish(restaurantId, dish);
		String response = environment.getProperty("RestaurantRegisterAPI.DISH_DETAILS_ADDED") + " Dish Id: " + id;
			
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "delete-dish/{restaurantId}/{dishId}")
	public ResponseEntity<String> deleteDish(@PathVariable Integer dishId, @PathVariable Integer restaurantId) throws Exception {
		logger.info("Delete given dish from given restaurant!");
		restaurantRegisterService.deleteDish(restaurantId, dishId);
		String response = environment.getProperty("RestaurantRegisterAPI.DISH_DETAILS_DELETED") + " Dish Id: " + dishId;
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
}
