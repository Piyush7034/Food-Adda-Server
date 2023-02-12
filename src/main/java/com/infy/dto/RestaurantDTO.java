package com.infy.dto;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RestaurantDTO {
	
	//Add the required annotation
	private Integer restaurantId;
	
	@NotNull(message="{Restaurant.INVALID_RESTAURANT_NAME}")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{Restaurant.INVALID_RESTAURANT_NAME}")
	private String restaurantName;
	
	@NotNull(message="{Restaurant.INVALID_RESTAURANT_CONTACT}")
	@Pattern(regexp = "[6-9][0-9]{9}", message = "{Restaurant.INVALID_RESTAURANT_CONTACT}")
	private String restaurantContact;
	
	@NotNull(message="{Restaurant.INVALID_RESTAURANT_TYPE}")
	private String restaurantType;
	
	@NotNull(message="{Restaurant.INVALID_RESTAURANT_STREET}")
	@Pattern(regexp = "[A-Za-z0-9-/., ]+", message = "{Restaurant.INVALID_RESTAURANT_STREET}")
	private String addressLine1;
	
	@NotNull(message="{Restaurant.INVALID_RESTAURANT_AREA}")
	@Size(min = 3, message = "{Restaurant.INVALID_RESTAURANT_AREA}")
	private String area;
	
	@NotNull(message="{Restaurant.INVALID_RESTAURANT_CITY}")
	@Size(min = 3, message = "{Restaurant.INVALID_RESTAURANT_CITY}")
	private String city;
	
	@NotNull(message="{Restaurant.INVALID_RESTAURANT_STATE}")
	private String resState;
	
	@Pattern(regexp = "[1-9][0-9]{5}", message = "{Restaurant.INVALID_RESTAURANT_PIN}")
	private Integer pincode;
	private String approvalStatus;
	
	@Pattern(regexp = "[1-5]", message = "{Restaurant.INVALID_RESTAURANT_RATING}")
	private double avgRating;
	private List<DishDTO> dishes;
	private List<String> photoUrls;
	private RestaurantTransactionDTO transaction;
	
	
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
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
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
	public List<DishDTO> getDishes() {
		return dishes;
	}
	public void setDishes(List<DishDTO> dishes) {
		this.dishes = dishes;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	public RestaurantTransactionDTO getTransaction() {
		return transaction;
	}
	public void setTransaction(RestaurantTransactionDTO transaction) {
		this.transaction = transaction;
	}
	public String getApprovalStatus() {
		return approvalStatus;
	}
	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	public double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

}