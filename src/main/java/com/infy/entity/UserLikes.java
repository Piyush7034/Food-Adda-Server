package com.infy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infy.dto.UserLikesDTO;

@Entity
@Table(name="user_likes")
public class UserLikes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer likeId;
	private String vegNonveg;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dish_id", unique = true)
	private Dish dish;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id", unique = true)
	private Restaurant restaurant;
	public Integer getLikeId() {
		return likeId;
	}
	public void setLikeId(Integer likeId) {
		this.likeId = likeId;
	}
	public String getVegNonveg() {
		return vegNonveg;
	}
	public void setVegNonveg(String vegNonveg) {
		this.vegNonveg = vegNonveg;
	}
	public Dish getDish() {
		return dish;
	}
	public void setDish(Dish dish) {
		this.dish = dish;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	public UserLikesDTO getUserLikesDTOFromUserLikes() {
		UserLikesDTO userLikesDTO = new UserLikesDTO();
		userLikesDTO.setLikeId(this.getLikeId());
		userLikesDTO.setVegNonveg(this.getVegNonveg());
		userLikesDTO.setDish(this.getDish().getDishDTOFromDish());
		userLikesDTO.setRestaurant(this.getRestaurant().getRestaurantDTOFromRestaurant());
		
		return userLikesDTO;
	}
	
	public static UserLikes getUserLikesFromUserLikesDTO(UserLikesDTO userLikesDTO) {
		UserLikes userLikes = new UserLikes();
		userLikes.setLikeId(userLikesDTO.getLikeId());
		userLikes.setVegNonveg(userLikesDTO.getVegNonveg());
		userLikes.setDish(Dish.getDishFromDishDTO(userLikesDTO.getDish()));
		userLikes.setRestaurant(Restaurant.getRestaurantFromRestaurantDTO(userLikesDTO.getRestaurant()));
		
		return userLikes;
	}
}
