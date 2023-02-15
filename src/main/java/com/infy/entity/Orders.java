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
import javax.persistence.Table;

import com.infy.dto.OrderItemsDTO;
import com.infy.dto.OrdersDTO;

@Entity
@Table(name="orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	private Integer orderBill;
	private String orderStatus;
	@OneToMany(cascade= CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private List<OrderItems> orderItemsList;
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	public Integer getOrderBill() {
		return orderBill;
	}
	public void setOrderBill(Integer orderBill) {
		this.orderBill = orderBill;
	}
	public List<OrderItems> getOrderItemsList() {
		return orderItemsList;
	}
	public void setOrderItemsList(List<OrderItems> orderItemsList) {
		this.orderItemsList = orderItemsList;
	}
	
	public OrdersDTO getOrdersDTOFromOrders() {
		OrdersDTO ordersDTO = new OrdersDTO();
		ordersDTO.setOrderId(this.getOrderId());
		ordersDTO.setOrderBill(this.getOrderBill());
		ordersDTO.setOrderStatus(this.getOrderStatus());
		List<OrderItemsDTO> orderItemsDTOList = new ArrayList<>();
		this.orderItemsList.
						forEach(orderItem -> orderItemsDTOList.
											add(orderItem.getOrderItemsDTOFromOrderItems()));
		ordersDTO.setOrderItemsList(orderItemsDTOList);
		
		return ordersDTO;
	}
	
	public static Orders getOrdersFromOrdersDTO(OrdersDTO ordersDTO) {
		Orders orders = new Orders();
		orders.setOrderId(ordersDTO.getOrderId());
		orders.setOrderBill(ordersDTO.getOrderBill());
		orders.setOrderStatus(ordersDTO.getOrderStatus());
		List<OrderItems> orderItemsList = new ArrayList<>();
		ordersDTO.getOrderItemsList().
						forEach(orderItemsDTO -> orderItemsList.
												add(OrderItems.getOrderItemsFromOrderItemsDTO(orderItemsDTO)));
		orders.setOrderItemsList(orderItemsList);
		
		return orders;
	}
	
}

