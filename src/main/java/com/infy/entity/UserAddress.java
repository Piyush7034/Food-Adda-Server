package com.infy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.dto.UserAddressDTO;

@Entity
@Table(name="user_address")
public class UserAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userAddressId;
	private String userAddressName;
	private String addressLine1;
	private String addressLine2;
	private String area;
	private String city;
	private String userState;
	private String pincode;
	public Integer getUserAddressId() {
		return userAddressId;
	}
	public void setUserAddressId(Integer userAddressId) {
		this.userAddressId = userAddressId;
	}
	
	public String getUserAddressName() {
		return userAddressName;
	}
	public void setUserAddressName(String userAddressName) {
		this.userAddressName = userAddressName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public UserAddressDTO getAddressDTOFromAddress() {
		UserAddressDTO userAddressDTO = new UserAddressDTO();
		
		userAddressDTO.setUserAddressId(this.getUserAddressId());
		userAddressDTO.setAddressLine1(this.getAddressLine1());
		userAddressDTO.setAddressLine2(this.getAddressLine2());
		userAddressDTO.setArea(this.getArea());
		userAddressDTO.setCity(this.getCity());
		userAddressDTO.setPincode(this.getPincode());
		userAddressDTO.setUserAddressName(this.getUserAddressName());
		userAddressDTO.setUserState(this.getUserState());
		
		return userAddressDTO;
	}
	
	public static UserAddress getAddressFromAddressDTO(UserAddressDTO userAddressDTO) {
		UserAddress userAddress = new UserAddress();
		
		userAddress.setUserAddressId(userAddressDTO.getUserAddressId());
		userAddress.setAddressLine1(userAddressDTO.getAddressLine1());
		userAddress.setAddressLine2(userAddressDTO.getAddressLine2());
		userAddress.setArea(userAddressDTO.getArea());
		userAddress.setCity(userAddressDTO.getCity());
		userAddress.setPincode(userAddressDTO.getPincode());
		userAddress.setUserAddressName(userAddressDTO.getUserAddressName());
		userAddress.setUserState(userAddressDTO.getUserState());
		
		return userAddress;
	}

}
