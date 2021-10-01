package com.sogeti.util;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sogeti.domain.Address;
import com.sogeti.domain.Customer;
import com.sogeti.domain.Order;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONParserImpl {

	private static JSONParserImpl instance;

	static JSONParser parser = new JSONParser();

	public static JSONParserImpl getInstance() {
		if (instance == null) {
			instance = new JSONParserImpl();
		}
		return instance;
	}

	public List<Customer> mapJSONCustomers() {
		List<Customer> customers = new ArrayList<Customer>();

		try {
			Object obj = parser.parse(new FileReader(".\\src\\main\\resources\\data\\customers.json"));
			JSONArray customerList = (JSONArray) obj;

			customerList.toString();
			Iterator<JSONObject> iterator = customerList.iterator();

			while (iterator.hasNext()) {
				JSONObject customerObj = iterator.next();
				Customer newCustomer = new Customer();
				newCustomer.setFirstName(customerObj.get("firstName").toString());
				newCustomer.setLastName(customerObj.get("lastName").toString());
				try {
				newCustomer.setAge(Integer.parseInt(customerObj.get("age").toString()));
				newCustomer.setPhoneNumber(Integer.parseInt(customerObj.get("phoneNumber").toString()));
				} catch(NumberFormatException e) {
					// TODO: implement error handling
					// do nothing
				}
				setAddress(newCustomer, customerObj);
				customers.add(newCustomer);
			}

		} catch (Exception e) {
			System.out.printf("Error with JSONParserImpl.parseCustomers", e.getStackTrace());
		}
		return customers;
	}

	private void setAddress(Customer customer, JSONObject customerObj) {
		JSONObject addressObj = (JSONObject) customerObj.get("address");
		Address addr = new Address();
		addr.setStreetAddress(addressObj.get("streetAddress").toString());
		addr.setCity(addressObj.get("city").toString());
		addr.setState(addressObj.get("state").toString());
		addr.setPostalCode(addressObj.get("postalCode").toString());
		customer.setAddress(addr);
	}


	public List<Order> mapJSONOrders() {
		// TODO Auto-generated method stub
		return null;
	}
}