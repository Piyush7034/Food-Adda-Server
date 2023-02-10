package com.infy.service;


import com.infy.dto.UserAddressDTO;
import com.infy.dto.UsersDTO;
import com.infy.repository.UserAddressRepository;
import com.infy.repository.UsersRepository;



public class UserServiceImpl implements UserService{
	
	
	private UsersRepository userRepository;
	
	
	private UserAddressRepository userAddressRepository;

	@Override
	public UsersDTO authenticateUser(String contactNumber, String password) throws Exception{
		
		//Your code goes here
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


