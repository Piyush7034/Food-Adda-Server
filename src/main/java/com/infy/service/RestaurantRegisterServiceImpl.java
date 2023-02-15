
package com.infy.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.DishDTO;
import com.infy.dto.RestaurantDTO;
import com.infy.entity.Dish;
import com.infy.entity.Restaurant;
import com.infy.entity.Users;
import com.infy.exception.FoodAddaException;
import com.infy.repository.DishRepository;
import com.infy.repository.RestaurantRepository;
import com.infy.repository.UsersRepository;


@Service(value = "restaurantRegisterService")
@Transactional
public class RestaurantRegisterServiceImpl implements RestaurantRegisterService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private DishRepository dishRepository;
	
	public Integer registerNewRestaurant(RestaurantDTO restaurantDTO,Integer userId) throws Exception {
		if(restaurantDTO == null) {
			throw new FoodAddaException("RestaurantRegisterService.RESTAURANT_DOES_NOT_EXIST");
		}
		
		Optional<Users> optionalUser = userRepository.findById(userId);
		Users user = optionalUser.
						orElseThrow(() -> new FoodAddaException("RestaurantRegisterService.NO_USER_FOUND"));
		
		List<Restaurant> restaurantList = user.getRestaurants();
		Restaurant restaurant = Restaurant.getRestaurantFromRestaurantDTO(restaurantDTO);
		restaurant = restaurantRepository.save(restaurant);
		restaurantList.add(restaurant);
		user.setRestaurants(restaurantList);
		
		return restaurant.getRestaurantId();
	}
	
	
	
	@Override
	public Integer addDish(Integer restaurantId, DishDTO dishDTO) throws Exception {
		Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);
		Restaurant restaurant = optionalRestaurant.
									orElseThrow(() -> new FoodAddaException("RestaurantRegisterService.RESTAURANT_DOES_NOT_EXIST"));
		List<Dish> dishList = restaurant.getDishes();
		if(dishDTO == null) {
			throw new FoodAddaException("RestaurantRegisterService.DISH_CANNOT_BE_ADDED");
		}		
		Dish dish = Dish.getDishFromDishDTO(dishDTO);
		dish = dishRepository.save(dish);
		dishList.add(dish);
		restaurant.setDishes(dishList);
		
		return dish.getDishId();
	}
	
	@Override
	public Integer updateDish(DishDTO dishDTO, Integer restaurantId) throws Exception {
		Optional<Dish> optionalDish = dishRepository.findById(dishDTO.getDishId());
		Dish dish = optionalDish.
						orElseThrow(() -> new FoodAddaException("RestaurantRegisterService.NO_DISH_FOUND"));
		
		Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);
		Restaurant restaurant = optionalRestaurant.
									orElseThrow(() -> new FoodAddaException("RestaurantRegisterService.RESTAURANT_DOES_NOT_EXIST"));
		
		List<Dish> dishList = restaurant.getDishes();
		dishList.forEach(d -> {
			if(d.getDishId().equals(dishDTO.getDishId())) {
				d = Dish.getDishFromDishDTO(dishDTO);
			}
		});
		restaurant.setDishes(dishList);
		
		return dish.getDishId();	
	}
	

	@Override
	public void deleteDish(Integer restaurantId, Integer dishId) throws Exception {
		Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);
		Restaurant restaurant = optionalRestaurant.
									orElseThrow(() -> new FoodAddaException("RestaurantRegisterService.RESTAURANT_DOES_NOT_EXIST"));
		
		Optional<Dish> optionalDish = dishRepository.findById(dishId);
		Dish dish = optionalDish.
						orElseThrow(() -> new FoodAddaException("RestaurantRegisterService.NO_DISH_FOUND"));
		
		List<Dish> dishList = restaurant.getDishes();
		dishList.remove(dish);
		restaurant.setDishes(dishList);
		dishRepository.deleteById(dishId);
	}
	

	@Override
	public List<DishDTO> viewDishes(Integer restaurantId) throws Exception {
		Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(restaurantId);
		Restaurant restaurant = optionalRestaurant.
									orElseThrow(() -> new FoodAddaException("RestaurantRegisterService.RESTAURANT_DOES_NOT_EXIST"));
		
		List<DishDTO> dishDTOList = new ArrayList<>();
		restaurant.getDishes()
					.forEach(dish -> dishDTOList.add(dish.getDishDTOFromDish()));
		
		return dishDTOList;
	}
	


	@Override
	public List<RestaurantDTO> viewRestaurants (Integer userId) throws Exception {
		Optional<Users> optionalUser = userRepository.findById(userId);
		Users user = optionalUser.
						orElseThrow(() -> new FoodAddaException("RestaurantRegisterService.NO_USER_FOUND"));
		
		List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
		
		user.getRestaurants()
				.forEach(restaurant -> restaurantDTOList.add(restaurant.getRestaurantDTOFromRestaurant()));
		
		return restaurantDTOList;
	}

}