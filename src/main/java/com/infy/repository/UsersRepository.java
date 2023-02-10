package com.infy.repository;


import org.springframework.data.repository.CrudRepository;

import com.infy.entity.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {
	
	//Add methods if required
	
}
