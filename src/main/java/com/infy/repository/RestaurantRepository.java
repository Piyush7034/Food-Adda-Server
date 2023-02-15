package com.infy.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.infy.entity.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer>{
	
	//Add methods if required
	List<Restaurant> findByArea(String area);
}
