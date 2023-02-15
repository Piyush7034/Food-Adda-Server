package com.infy.api;

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

import com.infy.dto.UserAddressDTO;
import com.infy.dto.UsersDTO;
import com.infy.service.RestaurantRecommendationService;
import com.infy.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/user-api")
public class UserAPI {
	
	@Autowired
	private UserService userService;

	@Autowired
	private Environment environment;
	
	@Autowired
	private RestaurantRecommendationService recommendationService;
	
	static Logger logger = LogManager.getLogger(UserAPI.class.getName());

	@PostMapping(value = "/register-user")
	public ResponseEntity<String> registerUser(@RequestBody @Valid UsersDTO userDTO) throws Exception {
		logger.info("Register a new user!");
		String id = userService.registerNewUser(userDTO);
		String response = environment.getProperty("UserAPI.REGISTER_USER_SUCCESS1") + 
							environment.getProperty("UserAPI.REGISTER_USER_SUCCESS2") + 
							id;
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


	@PostMapping(value = "/authenticate-user")
	public ResponseEntity<UsersDTO> authenticateUser(@RequestBody @Valid UsersDTO user) throws Exception {
		logger.info("Authenticate a user!");
		UsersDTO userDTO = userService.authenticateUser(user.getContactNumber(), user.getPassword());
		
		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
	
	@PostMapping(value = "/add-address/{userId}")
	public ResponseEntity<Integer> addAddress(@RequestBody @Valid UserAddressDTO address, Integer userId) throws Exception {
		logger.info("Add a address to user address list!");
		Integer response = userService.addNewAddress(address, userId);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping(value = "/update-address/{userId}")
	public ResponseEntity<String> updateAddress(@RequestBody @Valid UserAddressDTO address, @PathVariable Integer userId) throws Exception {
		logger.info("Update the user address with address id same as given address!");
		String response = userService.updateAddress(address, userId);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete-address/{addressId}/{userId}")
	public ResponseEntity<String> deleteAddress(@PathVariable Integer addressId, @PathVariable Integer userId) throws Exception {
		logger.info("Delete the given address from user addresses list!");
		userService.deleteAddress(addressId, userId);
		String response = environment.getProperty("UserAPI.ADDRESS_DETAILS_DELETED");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/get-address-list/{userId}")
	public ResponseEntity<UsersDTO> getUser(@PathVariable Integer userId) throws Exception{
		logger.info("Fetch a user!");
		UsersDTO userDTO = recommendationService.getUser(userId);

		return new ResponseEntity<>(userDTO, HttpStatus.OK);
	}
	
	

}
