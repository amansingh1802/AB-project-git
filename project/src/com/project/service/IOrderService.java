package com.project.service;

import com.project.pojos.Order;

public interface IOrderService 
{
	Order getOrderById(int orderId);
	Boolean saveOrUpdateOrder(Order o);
	public Boolean deleteOrder(Order o);
}
