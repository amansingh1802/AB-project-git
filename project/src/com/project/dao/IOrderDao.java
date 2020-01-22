package com.project.dao;

import com.project.pojos.Order;

public interface IOrderDao {
	Order getOrderById(int orderId);
	Boolean saveOrUpdateOrder(Order o);
	public Boolean deleteOrder(Order o);
}
