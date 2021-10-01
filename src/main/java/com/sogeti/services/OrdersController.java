package com.sogeti.services;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.domain.Order;
import com.sogeti.util.JSONParserImpl;

@RestController
public class OrdersController {

	@GetMapping("/orders")
	List<Order> all() {
		return JSONParserImpl.getInstance().mapJSONOrders();
	}

	@PostMapping("/orders")
	Order newOrder(@RequestBody Order newOrder) {
		// TODO: implement persistence
		return newOrder;
	}

	@GetMapping("/orders/{id}")
	Order getOrder(@PathVariable Integer id) {
		// TODO: implement persistence
		return null;
	}

	@PutMapping("/orders/{id}")
	Order updateOrder(@PathVariable Integer id) {
		// TODO: implement persistence
		return null;
	}

	@DeleteMapping("/orders/{id}")
	void deleteOrder(@PathVariable Integer id) {
		// TODO: implement persistence
	}
}
