package com.infy.service;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infy.dto.UserAddressDTO;
import com.infy.dto.UsersDTO;
import com.infy.entity.UserAddress;
import com.infy.entity.Users;
import com.infy.exception.FoodAddaException;
import com.infy.repository.UserAddressRepository;
import com.infy.repository.UsersRepository;


@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private UserAddressRepository userAddressRepository;
	
	@Autowired
	private Environment environment; 

	@Override
	public UsersDTO authenticateUser(String contactNumber, String password) throws Exception{
		Optional<Users> optionalUser = userRepository.findByContactNumber(contactNumber);
		Users user = optionalUser.
								orElseThrow(() -> new FoodAddaException("UserService.INVALID_CREDENTIALS"));
		
		if(!password.equals(user.getPassword())) {
			throw new FoodAddaException("UserService.INVALID_CREDENTIALS");
		}
		UsersDTO userDTO = user.getUserDTOFromUser();
		
		return userDTO;
	}
	
	@Override
	public String registerNewUser(UsersDTO userDTO) throws Exception{
		String result = null;
		Optional<Users> optionalUser = userRepository.findById(userDTO.getUserId());
		if(optionalUser.isEmpty()) {
			Users newUser = Users.getUserFromUserDTO(userDTO);
			Users user = userRepository.save(newUser);
			
			result = user.getUserId().toString();
		} else {
			throw new FoodAddaException("UserService.USER_ALREADY_EXISTS");
		}
		
		return result;
	}
			
	
	
	@Override
	public Integer addNewAddress(UserAddressDTO addressDTO, Integer userId) throws Exception {
		Optional<UserAddress> optionalUserAddress = userAddressRepository.findById(addressDTO.getUserAddressId());
		UserAddress userAddress = null;
		if(optionalUserAddress.isEmpty()) {
			Users user = userRepository.findById(userId).get();
			List<UserAddress> userAddressList = user.getAddressList();
			userAddress = userAddressRepository.save(UserAddress.getAddressFromAddressDTO(addressDTO));
			userAddressList.add(userAddress);
			user.setAddressList(userAddressList);
		} else  {
			throw new FoodAddaException("UserService.ADDRESS_NAME_ALREADY_EXISTS");
		}
		
		return userAddress.getUserAddressId();
	}

	@Override
	public String updateAddress(UserAddressDTO address, Integer userId) throws Exception {
		Optional<UserAddress> optionalUserAddress = userAddressRepository.findById(address.getUserAddressId());
		UserAddress userAddress = optionalUserAddress.
											orElseThrow(() -> new FoodAddaException("UserService.ADDRESS_NOT_FOUND"));
		
		Users user = userRepository.findById(userId).get();
		List<UserAddress> userAddressList = user.getAddressList();
		userAddressList.forEach(ad -> {
			if(ad.getUserAddressId().equals(userAddress.getUserAddressId())) {
				ad = UserAddress.getAddressFromAddressDTO(address);
			}
		});
		user.setAddressList(userAddressList);
		
		return environment.getProperty("UserService.UPDATE_ADDRESS");
	}
	
	@Override
	public void deleteAddress(Integer addressId, Integer userId) throws Exception {
		Optional<UserAddress> optionalUserAddress = userAddressRepository.findById(addressId);
		UserAddress userAddress = optionalUserAddress.
											orElseThrow(() -> new FoodAddaException("UserService.ADDRESS_NOT_FOUND"));
		
		Users user = userRepository.findById(userId).get();
		List<UserAddress> userAddressList = user.getAddressList();
		userAddressList.remove(userAddress);
		user.setAddressList(userAddressList);
				
	}
}


