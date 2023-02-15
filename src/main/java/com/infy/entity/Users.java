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

import com.infy.dto.OrdersDTO;
import com.infy.dto.RestaurantDTO;
import com.infy.dto.RolesDTO;
import com.infy.dto.UserAddressDTO;
import com.infy.dto.UserLikesDTO;
import com.infy.dto.UsersDTO;

@Entity
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	private String emailId;
	private String contactNumber;
	private String password;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private List<Roles> roles;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private List<Restaurant> restaurants;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<UserAddress> addressList;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", unique = true)
	private Wallet wallet;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private List<UserLikes> userLikesList;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Orders> ordersList;
	

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	public List<UserAddress> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<UserAddress> addressList) {
		this.addressList = addressList;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	public List<UserLikes> getUserLikesList() {
		return userLikesList;
	}
	public void setUserLikesList(List<UserLikes> userLikesList) {
		this.userLikesList = userLikesList;
	}
	public List<Orders> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
	
	public UsersDTO getUserDTOFromUser() {
		UsersDTO userDTO = new UsersDTO();
		
		userDTO.setUserId(this.getUserId());
		userDTO.setUserName(this.getUserName());
		userDTO.setEmailId(this.getEmailId());
		userDTO.setContactNumber(this.getContactNumber());
		userDTO.setPassword(this.getPassword());
		userDTO.setAddressList(this.getUserAddressDTOList());
		userDTO.setOrdersList(this.getOrdersDTOList());
		userDTO.setRestaurants(this.getRestaurantDTOList());
		userDTO.setUserLikesList(this.getUserLikesDTOList());
		userDTO.setRoles(this.getRolesDTOList());
		userDTO.setWallet(this.wallet.getWalletDTOFromWallet());
		return userDTO;
	}
	
	public static Users getUserFromUserDTO(UsersDTO userDTO) {
		Users user = new Users();
		user.setUserId(userDTO.getUserId());
		user.setUserName(userDTO.getUserName());
		user.setEmailId(userDTO.getEmailId());
		user.setContactNumber(userDTO.getContactNumber());
		user.setPassword(userDTO.getPassword());
		user.setAddressList(getUserAddressListFromDTO(userDTO.getAddressList()));
		user.setOrdersList(getOrdersListFromDTO(userDTO.getOrdersList()));
		user.setRestaurants(getRestaurantListFromDTO(userDTO.getRestaurants()));
		user.setRoles(getRolesListFromDTO(userDTO.getRoles()));
		user.setUserLikesList(getUsersLikesListFromDTO(userDTO.getUserLikesList()));
		user.setWallet(Wallet.getWalletFromWalletDTO(userDTO.getWallet()));
		return user;
	}
	
	private List<UserAddressDTO> getUserAddressDTOList() {
		List<UserAddressDTO> userAddressDTOList = new ArrayList<>();
		this.getAddressList().
					forEach(userAddress -> userAddressDTOList.add(userAddress.getAddressDTOFromAddress()));
		
		return userAddressDTOList;
	}
	
	private List<RolesDTO> getRolesDTOList() {
		List<RolesDTO> rolesDTOList = new ArrayList<>();
		this.getRoles().
					forEach(role -> rolesDTOList.add(role.getRolesDTOFromRoles()));
		
		return rolesDTOList;
	}
	
	private List<RestaurantDTO> getRestaurantDTOList() {
		List<RestaurantDTO> restaurantDTOList = new ArrayList<>();
		this.getRestaurants().
					forEach(restaurant -> restaurantDTOList.add(restaurant.getRestaurantDTOFromRestaurant()));
		
		return restaurantDTOList;
	}
	
	private List<UserLikesDTO> getUserLikesDTOList() {
		List<UserLikesDTO> userLikesDTOList = new ArrayList<>();
		this.getUserLikesList().
					forEach(userLikes -> userLikesDTOList.add(userLikes.getUserLikesDTOFromUserLikes()));
		
		
		return userLikesDTOList;
	}
	
	private List<OrdersDTO> getOrdersDTOList() {
		List<OrdersDTO> ordersDTOList = new ArrayList<>();
		this.getOrdersList().
					forEach(orders -> ordersDTOList.add(orders.getOrdersDTOFromOrders()));
		
		return ordersDTOList;
	}
	
	private static List<UserAddress> getUserAddressListFromDTO(List<UserAddressDTO> userAddressDTOList) {
		List<UserAddress> userAddressList= new ArrayList<>();
		userAddressDTOList.forEach(userAddressDTO -> userAddressList.add(UserAddress.getAddressFromAddressDTO(userAddressDTO)));
		
		return userAddressList;
	}
	
	private static List<Roles> getRolesListFromDTO(List<RolesDTO> rolesDTOList) {
		List<Roles> rolesList = new ArrayList<>();
		rolesDTOList.forEach(roleDTO -> rolesList.add(Roles.getRolesFromRolesDTO(roleDTO)));
		
		return rolesList;
	}
	
	private static List<UserLikes> getUsersLikesListFromDTO(List<UserLikesDTO> userLikesDTOList) {
		List<UserLikes> userLikesList = new ArrayList<>();
		userLikesDTOList.forEach(userLikeDTO -> userLikesList.add(UserLikes.getUserLikesFromUserLikesDTO(userLikeDTO)));
		
		return userLikesList;
	}
	
	private static List<Restaurant> getRestaurantListFromDTO(List<RestaurantDTO> restaurantDTOList) {
		List<Restaurant> restaurantList = new ArrayList<>();
		restaurantDTOList.forEach(restaurantDTO -> restaurantList.add(Restaurant.getRestaurantFromRestaurantDTO(restaurantDTO)));
		return restaurantList;
	}
	
	private static List<Orders> getOrdersListFromDTO(List<OrdersDTO> ordersDTOList) {
		List<Orders> ordersList = new ArrayList<>();
		ordersDTOList.forEach(orderDTO -> ordersList.add(Orders.getOrdersFromOrdersDTO(orderDTO)));
		return ordersList;
	}
}
