package com.bankmanagement.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagement.customer.entity.CustomerEntity;
import com.bankmanagement.customer.entity.UpdateCustomer;
import com.bankmanagement.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customerRegister")
	public ResponseEntity<String> customerRegister(@RequestBody CustomerEntity customerRequest)
	{
		return customerService.customerRegister(customerRequest);
	}
	
	@PostMapping("/updateRegister")
	public ResponseEntity<String> updateCustomer(@RequestParam(value="userName") String userName, @RequestBody UpdateCustomer updateCustomer)
	{
		return customerService.updateCustomer(userName,updateCustomer);
	}
	
	@PostMapping("/loginCustomer")
	public ResponseEntity<String> loginCustome(@RequestParam(value="userName") String userName, @RequestParam(value="password") String password)
	{
		return customerService.loginCustomer(userName,password);
	}
	
}
