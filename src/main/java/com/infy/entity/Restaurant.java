package com.infy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infy.dto.DishDTO;
import com.infy.dto.RestaurantDTO;

@Entity
@Table(name="restaurant")
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurantId;
	private String restaurantName;
	private String restaurantContact;
	private String restaurantType;
	private String addressLine1;
	private String area;
	private String city;
	private String resState;
	private Integer pincode;
	private String approvalStatus;
	private Double avgRating;
	private String photoUrls;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "restaurant_id")
	private List<Dish> dishes;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id", unique = true)
	private RestaurantTransaction transaction;
	public Integer getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantContact() {
		return restaurantContact;
	}
	public void setRestaurantContact(String restaurantContact) {
		this.restaurantContact = restaurantContact;
	}
	public String getRestaurantType() {
		return restaurantType;
	}
	public void setRestaurantType(String restaurantType) {
		this.restaurantType = restaurantType;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String adressLine1) {
		this.addressLine1 = adressLine1;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getResState() {
		return resState;
	}
	public void setResState(String resState) {
		this.resState = resState;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public List<Dish> getDishes() {
		return dishes;
	}
	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}
	public String getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(String photoUrls) {
		this.photoUrls = photoUrls;
	}
	public RestaurantTransaction getTransaction() {
		return transaction;
	}
	public void setTransaction(RestaurantTransaction transaction) {
		this.transaction = transaction;
	}

	public RestaurantDTO getRestaurantDTOFromRestaurant() {
		RestaurantDTO restaurantDTO = new RestaurantDTO();
		restaurantDTO.setRestaurantId(this.getRestaurantId());
		restaurantDTO.setRestaurantName(this.getRestaurantName());
		restaurantDTO.setRestaurantContact(this.getRestaurantContact());
		restaurantDTO.setRestaurantType(this.getRestaurantType());
		restaurantDTO.setAddressLine1(this.getAddressLine1());
		restaurantDTO.setArea(this.getArea());
		restaurantDTO.setCity(this.getCity());
		restaurantDTO.setPincode(this.getPincode());
		restaurantDTO.setAvgRating(this.getAvgRating());
		restaurantDTO.setApprovalStatus(this.getApprovalStatus());
		restaurantDTO.setResState(this.getResState());
		List<DishDTO> dishDTOList = new ArrayList<>();
		this.dishes.
				forEach(dish -> dishDTOList.add(dish.getDishDTOFromDish()));
		restaurantDTO.setDishes(dishDTOList);
		
		return restaurantDTO;
	}
	
	public static Restaurant getRestaurantFromRestaurantDTO(RestaurantDTO restaurantDTO) {
		Restaurant restaurant = new Restaurant();
		restaurant.setRestaurantId(restaurantDTO.getRestaurantId());
		restaurant.setRestaurantName(restaurantDTO.getRestaurantName());
		restaurant.setRestaurantContact(restaurantDTO.getRestaurantContact());
		restaurant.setRestaurantType(restaurantDTO.getRestaurantType());
		restaurant.setAddressLine1(restaurantDTO.getAddressLine1());
		restaurant.setArea(restaurantDTO.getArea());
		restaurant.setCity(restaurantDTO.getCity());
		restaurant.setPincode(restaurantDTO.getPincode());
		restaurant.setAvgRating(restaurantDTO.getAvgRating());
		restaurant.setApprovalStatus(restaurantDTO.getApprovalStatus());
		restaurant.setResState(restaurantDTO.getResState());
		List<Dish> dishList = new ArrayList<>();
		restaurantDTO.getDishes().
				forEach(dishDTO -> dishList.add(Dish.getDishFromDishDTO(dishDTO)));
		restaurant.setDishes(dishList);
		
		return restaurant;
	}

}
