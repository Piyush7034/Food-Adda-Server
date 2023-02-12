package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.dto.RestaurantTransactionDTO;

@Entity
@Table(name="restaurant_transaction")
public class RestaurantTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurantTransactionId;
	private Integer restaurantOrderCounter;
	private Integer restaurantApproxCost;
	private Boolean restaurantStatus;
	
	public Integer getRestaurantTransactionId() {
		return restaurantTransactionId;
	}
	public void setRestaurantTransactionId(Integer restaurantTransactionId) {
		this.restaurantTransactionId = restaurantTransactionId;
	}
	public Integer getRestaurantOrderCounter() {
		return restaurantOrderCounter;
	}
	public void setRestaurantOrderCounter(Integer restaurantOrderCounter) {
		this.restaurantOrderCounter = restaurantOrderCounter;
	}
	public Integer getRestaurantApproxCost() {
		return restaurantApproxCost;
	}
	public void setRestaurantApproxCost(Integer restaurantApproxCost) {
		this.restaurantApproxCost = restaurantApproxCost;
	}
	public Boolean getRestaurantStatus() {
		return restaurantStatus;
	}
	public void setRestaurantStatus(Boolean restaurantStatus) {
		this.restaurantStatus = restaurantStatus;
	}
	
	public RestaurantTransactionDTO getTransactionDTOFromTransaction() {
		RestaurantTransactionDTO restaurantTransactionDTO = new RestaurantTransactionDTO();
		restaurantTransactionDTO.setRestaurantTransactionId(this.getRestaurantTransactionId());
		restaurantTransactionDTO.setRestaurantOrderCounter(this.getRestaurantOrderCounter());
		restaurantTransactionDTO.setRestaurantApproxCost(this.getRestaurantApproxCost());
		restaurantTransactionDTO.setRestaurantStatus(this.getRestaurantStatus());
		
		return restaurantTransactionDTO;
	}
	
	public static RestaurantTransaction getTransactionFromTransactionDTO(RestaurantTransactionDTO restaurantTransactionDTO) {
		RestaurantTransaction restaurantTransaction = new RestaurantTransaction();
		restaurantTransaction.setRestaurantTransactionId(restaurantTransactionDTO.getRestaurantTransactionId());
		restaurantTransaction.setRestaurantOrderCounter(restaurantTransactionDTO.getRestaurantOrderCounter());
		restaurantTransaction.setRestaurantApproxCost(restaurantTransactionDTO.getRestaurantApproxCost());
		restaurantTransaction.setRestaurantStatus(restaurantTransactionDTO.getRestaurantStatus());
		
		return restaurantTransaction;
	}
}
