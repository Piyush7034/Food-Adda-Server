package com.infy.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DishDTO {

	//Add the required annotation
	private Integer dishId;
	@NotNull(message="{Dish.INVALID_DISH_NAME}")
	@Pattern(regexp = "[A-Za-z]+( [A-Za-z]+)*", message = "{Dish.INVALID_DISH_NAME}")
	private String dishName;
	
	@NotNull(message="{Dish.INVALID_DISH_CUISINE}")
	private String dishCuisine;
	
	@NotNull(message="{Dish.INVALID_DISH_TYPE}")
	private String dishType;
	
	@NotNull(message="{Dish.INVALID_DISH_}")
	private String dishDescription;
	
	@NotNull(message="{Dish.INVALID_DISH_PRICE}")
	@Min(value = 0, message = "{Dish.INVALID_DISH_PRICE}")
	private Double price;
	private Double avgRating;
	
	@NotNull(message="{Dish.INVALID_DISH_SPECIALITY}")
	private String speciality;
	private String imageUrl;


	public Integer getDishId() {
		return dishId;
	}
	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public String getDishCuisine() {
		return dishCuisine;
	}
	public void setDishCuisine(String dishCuisine) {
		this.dishCuisine = dishCuisine;
	}
	public String getDishType() {
		return dishType;
	}
	public void setDishType(String dishType) {
		this.dishType = dishType;
	}
	public String getDishDescription() {
		return dishDescription;
	}
	public void setDishDescription(String dishDescription) {
		this.dishDescription = dishDescription;
	}
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(Double avgRating) {
		this.avgRating = avgRating;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
