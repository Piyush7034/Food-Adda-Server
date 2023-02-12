package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.dto.DishDTO;

@Entity
@Table(name = "dish")
public class Dish {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dishId;
	private String dishName;
	private String dishCuisine;
	private String dishType;
	private String dishDescription;
	private Double price;
	private Double avgRating;
	private String speciality;
	private String imageUrl;

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

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

	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public DishDTO getDishDTOFromDish() {
		DishDTO dishDTO = new DishDTO();
		dishDTO.setDishId(this.getDishId());
		dishDTO.setDishName(this.getDishName());
		dishDTO.setDishType(this.getDishType());
		dishDTO.setDishDescription(this.getDishDescription());
		dishDTO.setDishCuisine(this.getDishCuisine());
		dishDTO.setSpeciality(this.getSpeciality());
		dishDTO.setPrice(this.getPrice());
		dishDTO.setImageUrl(this.getImageUrl());
		dishDTO.setAvgRating(this.getAvgRating());
		
		return dishDTO;
	}
	
	public static Dish getDishFromDishDTO(DishDTO dishDTO) {
		Dish dish = new Dish();
		dish.setDishId(dishDTO.getDishId());
		dish.setDishName(dishDTO.getDishName());
		dish.setDishType(dishDTO.getDishType());
		dish.setDishDescription(dishDTO.getDishDescription());
		dish.setDishCuisine(dishDTO.getDishCuisine());
		dish.setSpeciality(dishDTO.getSpeciality());
		dish.setPrice(dishDTO.getPrice());
		dish.setImageUrl(dishDTO.getImageUrl());
		dish.setAvgRating(dishDTO.getAvgRating());
		
		return dish;
	}
	
}
