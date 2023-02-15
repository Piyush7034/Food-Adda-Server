package com.infy.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.infy.dto.TableBookingDTO;

@Entity
@Table(name="table_booking")
public class TableBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	private Date bookingDate;
	private LocalDateTime timeOfBooking;
	private Integer noOfPeople;
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", unique = true)
	private Users user;
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalDateTime getTimeOfBooking() {
		return timeOfBooking;
	}
	public void setTimeOfBooking(LocalDateTime timeOfBooking) {
		this.timeOfBooking = timeOfBooking;
	}
	public Integer getNoOfPeople() {
		return noOfPeople;
	}
	public void setNoOfPeople(Integer noOfPeople) {
		this.noOfPeople = noOfPeople;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	public TableBookingDTO getTableBookingDTOFromTableBooking() {
		TableBookingDTO tableBookingDTO = new TableBookingDTO();
		tableBookingDTO.setBookingId(this.getBookingId());
		tableBookingDTO.setBookingDate(this.getBookingDate());
		tableBookingDTO.setTimeOfBooking(this.getTimeOfBooking());
		tableBookingDTO.setNoOfPeople(this.getNoOfPeople());
		tableBookingDTO.setRestaurant(this.getRestaurant().getRestaurantDTOFromRestaurant());
		tableBookingDTO.setUser(this.getUser().getUserDTOFromUser());
		
		return tableBookingDTO;
	}
	
	public static TableBooking getTableBookingFromTableBookingDTO(TableBookingDTO tableBookingDTO) {
		TableBooking tableBooking = new TableBooking();
		tableBooking.setBookingId(tableBookingDTO.getBookingId());
		tableBooking.setBookingDate(tableBookingDTO.getBookingDate());
		tableBooking.setTimeOfBooking(tableBookingDTO.getTimeOfBooking());
		tableBooking.setNoOfPeople(tableBookingDTO.getNoOfPeople());
		tableBooking.setRestaurant(Restaurant.getRestaurantFromRestaurantDTO(tableBookingDTO.getRestaurant()));
		tableBooking.setUser(Users.getUserFromUserDTO(tableBookingDTO.getUser()));
		
		return tableBooking;
	}

}
