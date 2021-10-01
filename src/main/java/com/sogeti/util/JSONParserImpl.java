package com.sogeti.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sogeti.domain.Address;
import com.sogeti.domain.Customer;
import com.sogeti.domain.Order;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
			JSONArray customerJSONArray = readJSONData(".\\src\\main\\resources\\data\\customers.json");
			instantiateJSONCustomers(customers, customerJSONArray);
		} catch (Exception e) {
			System.out.printf("Error with JSONParserImpl.parseCustomers", e.getStackTrace());
		}
		return customers;
	}

	private void instantiateJSONCustomers(List<Customer> customers, JSONArray customerList) {
		Iterator<JSONObject> iterator = customerList.iterator();
		int uniqueIdIndex = 0;
		while (iterator.hasNext()) {
			JSONObject customerJSON = iterator.next();
			Customer newCustomer = new Customer();
			newCustomer.setId(Integer.toString(uniqueIdIndex));
			newCustomer.setFirstName(customerJSON.get("firstName").toString());
			newCustomer.setLastName(customerJSON.get("lastName").toString());
			try {
				newCustomer.setAge(Integer.parseInt(customerJSON.get("age").toString()));
				newCustomer.setPhoneNumber(Integer.parseInt(customerJSON.get("phoneNumber").toString()));
			} catch (NumberFormatException e) {
				// TODO: implement error handling
				// do nothing
			}
			setCustomerAddress(newCustomer, customerJSON);
			customers.add(newCustomer);
			uniqueIdIndex++;
		}
	}

	private void setCustomerAddress(Customer customer, JSONObject customerJSON) {
		JSONObject addressObj = (JSONObject) customerJSON.get("address");
		Address addr = new Address();
		addr.setStreetAddress(addressObj.get("streetAddress").toString());
		addr.setCity(addressObj.get("city").toString());
		addr.setState(addressObj.get("state").toString());
		addr.setPostalCode(addressObj.get("postalCode").toString());
		customer.setAddress(addr);
	}

	public JSONArray readJSONData(String filePath) throws FileNotFoundException, IOException, ParseException {
		Object obj = parser.parse(new FileReader(filePath));
		return (JSONArray) obj;
	}

	public List<Order> mapJSONOrders() {
		// TODO Auto-generated method stub
		return null;
	}
}