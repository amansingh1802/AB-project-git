package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.pojos.Order;
import com.project.service.IOrderService;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController 
{
	@Autowired
	private IOrderService orderService;
	
	@GetMapping("/get/{orderId}")
	public ResponseEntity<?> getOrderById(@PathVariable int orderId)
	{
		Order o = orderService.getOrderById(orderId);
		if(o != null)
			return new ResponseEntity<Order>(o, HttpStatus.OK);
		return new ResponseEntity<String>("No Order Found", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/addOrder")
	public ResponseEntity<?> saveOrUpdateOrder(@RequestBody Order o)
	{
		if(orderService.saveOrUpdateOrder(o))
			return new ResponseEntity<String>("SUCCESS!!!", HttpStatus.OK);
		return new ResponseEntity<String>("FAILED!!!", HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/delete")
	public ResponseEntity<?> deleteOrder(@RequestBody Order o)
	{
		if(orderService.deleteOrder(o))
			return new ResponseEntity<String>("Deleted successfully!!!", HttpStatus.OK);
		return new ResponseEntity<String>("Failed to delete your order!!!", HttpStatus.NOT_FOUND);
	}
}
