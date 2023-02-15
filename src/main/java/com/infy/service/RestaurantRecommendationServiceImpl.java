package com.infy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.RestaurantDTO;
import com.infy.dto.UsersDTO;
import com.infy.entity.Restaurant;
import com.infy.entity.Users;
import com.infy.exception.FoodAddaException;
import com.infy.repository.RestaurantRepository;
import com.infy.repository.UsersRepository;

@Service(value = "recommendationService")
@Transactional
public class RestaurantRecommendationServiceImpl implements RestaurantRecommendationService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private UsersRepository userRepository;

	@Override
	public List<RestaurantDTO> getRecommendationByArea(String area) throws Exception {	
		List<Restaurant> restaurantList = restaurantRepository.findByArea(area);
		if(restaurantList.isEmpty()) {
			throw new FoodAddaException("RecommendationService.NO_RESTAURANT_FOUND");
		}
		List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
		restaurantList.
					forEach(restaurant -> restaurantDTOList.add(restaurant.getRestaurantDTOFromRestaurant()));
		
		return restaurantDTOList;
	}

	@Override
	public UsersDTO getUser(Integer userId) throws Exception {
		Optional<Users> optionalUser = userRepository.findById(userId);
		Users user = optionalUser.
								orElseThrow(() -> new FoodAddaException("orderService.NO_USER_FOUND"));
		UsersDTO userDTO = user.getUserDTOFromUser();
		
		return userDTO;
	}

}
