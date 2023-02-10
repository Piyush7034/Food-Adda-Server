package com.infy.api;

import javax.validation.Valid;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;

import com.infy.dto.UserAddressDTO;
import com.infy.dto.UsersDTO;
import com.infy.service.RestaurantRecommendationService;
import com.infy.service.UserService;


public class UserAPI {
	
	
	private UserService userService;

	
	private Environment environment;
	
	
	private RestaurantRecommendationService recommendationService;

	
	
	public ResponseEntity<String> registerUser(UsersDTO user) throws Exception {


		//Your code goes here
		   return null;
		
	}


	
	public ResponseEntity<UsersDTO> authenticateUser(UsersDTO user) throws Exception {

		//Your code goes here
		   return null;
	}
	
	
	public ResponseEntity<Integer> addAddress(UserAddressDTO address,Integer userId) throws Exception {
		
		//Your code goes here
		   return null;
	}
	
	
	public ResponseEntity<String> updateAddress(UserAddressDTO address, Integer userId) throws Exception {

		//Your code goes here
		   return null;

	}

	
	
	public ResponseEntity<String> deleteAddress(Integer addressId, Integer userId) throws Exception {

		//Your code goes here
		   return null;
		

	}
	
	public ResponseEntity<UsersDTO> getAddressList(Integer userId) throws Exception{
		
		//Your code goes here
		   return null;
	}
	
	

}
