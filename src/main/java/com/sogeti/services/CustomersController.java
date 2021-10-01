package com.sogeti.services;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sogeti.domain.Customer;
import com.sogeti.util.JSONParserImpl;

@RestController
public class CustomersController {
	
	  @GetMapping("/customers")
	  List<Customer> getCustomers() {
	    return JSONParserImpl.getInstance().mapJSONCustomers();
	  }
	  
	  @GetMapping("/customers/{id}/orders")
	  List<Customer> getCustomerOrders(@PathVariable Integer id) {
		  //TODO: Implement Persistence
	    return null;
	  }
}
