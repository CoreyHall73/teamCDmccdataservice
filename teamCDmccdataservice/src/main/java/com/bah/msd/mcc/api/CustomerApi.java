package com.bah.msd.mcc.api;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bah.msd.mcc.domain.CustomerClass;

@RestController
@RequestMapping("/customers")
public class CustomerApi {

	// Hardcode customer dummy data
	ArrayList<CustomerClass> customerList = new ArrayList<CustomerClass>();

	public CustomerApi() {
		CustomerClass c1 = new CustomerClass(1, "Austin", "pass", "austin@bah.com");
		CustomerClass c2 = new CustomerClass(2, "Michael", "pass", "michael@bah.com");
		CustomerClass c3 = new CustomerClass(3, "Timothy", "pass", "timothy@bah.com");
		CustomerClass c4 = new CustomerClass(4, "Chris", "pass", "chris@bah.com");
		CustomerClass c5 = new CustomerClass(5, "Corey", "pass", "corey@bah.com");
		CustomerClass c6 = new CustomerClass(6, "Jay", "pass", "jay@bah.com");
		CustomerClass c7 = new CustomerClass(7, "Phu", "pass", "Phu@bah.com");
		CustomerClass c8 = new CustomerClass(8, "Dipendra", "pass", "dipendra@bah.com");
		
		customerList.add(c1);
		customerList.add(c2);
		customerList.add(c3);
		customerList.add(c4);
		customerList.add(c5);
		customerList.add(c6);
		customerList.add(c7);
		customerList.add(c8);
	}

	// Route for read all
	@GetMapping
	public Collection<CustomerClass> getAllCustomers() {
		return this.customerList;
	}

	// Rout for read one by ID
	@GetMapping("/{id}")
	public CustomerClass getOneById(@PathVariable long id) {
		
		// Set to null
		CustomerClass customer = null;
		
		// return if ID matches
		for(int i = 0; i < customerList.size(); i++) {
			if(customerList.get(i).getId() == id) {
				customer = customerList.get(i);
			}
		}
		// If no match return customer as null
		return customer;
	}

}
