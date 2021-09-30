package com.sogeti;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * This is the hub for testing the API due to requirements all tests
 * will be housed in this class for efficiency and to fulfill the requirement
 * "Tests to prove your code works as expected"\
 * 
 * @author Jordan M. Schall
 *
 */



@SpringBootTest
class RestApiApplicationTests {
	
    @Autowired
    MockMvc mockMvc;
    
	//Initialize spring tests
	@Test
	void contextLoads() {
	}
	
	//Create order endpoint
	@Test
	void testOrderEndpoint() throws Exception {
		 mockMvc.perform(MockMvcRequestBuilders
		            .get("/order")
		            .contentType(MediaType.APPLICATION_JSON))
		            .andExpect(status().isOk());
		            //.andExpect(jsonPath("$[2].name", is("Jane Doe")));
	}
	
	//List all orders by customer endpoint
	@Test
	void testListOrdersByCustomerEndpoint() throws Exception {
		 mockMvc.perform(MockMvcRequestBuilders
		            .get("/orders")
		            .contentType(MediaType.APPLICATION_JSON))
		            .andExpect(status().isOk());
		
	}
	
	//Update order endpoint
	@Test
	void testUpdateOrderEndpoint() throws Exception {
		 mockMvc.perform(MockMvcRequestBuilders
		            .put("/order")
		            .contentType(MediaType.APPLICATION_JSON))
		            .andExpect(status().isOk());
	}
	
	//Cancel order endpoint
	@Test
	void testCancelOrderEndpoint() throws Exception {
		 mockMvc.perform(MockMvcRequestBuilders
		            .post("/order")
		            .contentType(MediaType.APPLICATION_JSON))
		            .andExpect(status().isOk());
	}

}
