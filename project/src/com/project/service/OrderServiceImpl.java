package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.IOrderDao;
import com.project.pojos.Order;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private IOrderDao orderDao;

	@Override
	public Order getOrderById(int orderId) {
		return orderDao.getOrderById(orderId);
	}

	@Override
	public Boolean saveOrUpdateOrder(Order o) {
		return orderDao.saveOrUpdateOrder(o);
	}

	@Override
	public Boolean deleteOrder(Order o) {
		return orderDao.deleteOrder(o);
	}

}
