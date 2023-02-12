package com.infy.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.UserAddressDTO;
import com.infy.dto.UsersDTO;
import com.infy.entity.Users;
import com.infy.exception.FoodAddaException;
import com.infy.repository.UserAddressRepository;
import com.infy.repository.UsersRepository;


@Service(value = "userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private UserAddressRepository userAddressRepository;

	@Override
	public UsersDTO authenticateUser(String contactNumber, String password) throws Exception{
		
		Optional<Users> optionalUser = userRepository.findByContactNumber(contactNumber);
		Users user = optionalUser.
								orElseThrow(() -> new FoodAddaException("UserService.INVALID_CREDENTIALS"));
		
		if(!password.equals(user.getPassword())) {
			throw new FoodAddaException("UserService.INVALID_CREDENTIALS");
		}
		
		UsersDTO userDTO = new UsersDTO();
		userDTO.setUserName(user.getUserName());
		userDTO.setContactNumber(user.getContactNumber());
		userDTO.setEmailId(user.getEmailId());
		userDTO.setUserId(user.getUserId());
//		userDTO.setAddressList(user.getAddressList());
//		userDTO.setOrdersList(user.getOrdersList());
//		userDTO.setRestaurants(user.getRestaurants());
//		userDTO.setRoles(user.getRoles());
//		userDTO.setUserLikesList(user.getUserLikesList());
//		userDTO.setWallet();
//		
		return null;
	}
	
	@Override
	public String registerNewUser(UsersDTO user) throws Exception{
		
		//Your code goes here
				return null;
		}
			
	
	
	@Override
	public Integer addNewAddress(UserAddressDTO address, Integer userId) throws Exception {
		
		//Your code goes here
				return null;
	}

	@Override
	public String updateAddress(UserAddressDTO address, Integer userId) throws Exception {

		//Your code goes here
				return null;
	}
	
	@Override
	public void deleteAddress(Integer addressId, Integer userId) throws Exception {
			
		//Your code goes here
				
	}
}


