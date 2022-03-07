package com.bankmanagement.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bankmanagement.customer.entity.CustomerEntity;
import com.bankmanagement.customer.entity.UpdateCustomer;
import com.bankmanagement.customer.repo.CustomerRepo;

@Service
public class CustomerService {

	@Autowired
	CustomerRepo customerRepo;
	
	public ResponseEntity<String> customerRegister(CustomerEntity customerRequest)
	{
		customerRepo.save(customerRequest);
		return ResponseEntity.ok("Success");
	}
	
	public ResponseEntity<String> updateCustomer(String userName, UpdateCustomer updateCustomer)
	{
		///hi i merge 3
		CustomerEntity customerEntity = customerRepo.findByUserName(userName);
		if(customerEntity == null)
		{
			return ResponseEntity.ok("User Name is not found in DataBase");
		}
		else
		{
			// hii i merge 4
			if(!(updateCustomer.getAddress().equalsIgnoreCase(customerEntity.getAddress())))
				customerEntity.setAddress(updateCustomer.getAddress());
			if(!(updateCustomer.getCountry().equalsIgnoreCase(customerEntity.getCountry())))
				customerEntity.setCountry(updateCustomer.getCountry());
			if(!(updateCustomer.getState().equalsIgnoreCase(customerEntity.getState())))
				customerEntity.setState(updateCustomer.getState());
			if(!(updateCustomer.getEmailAddress().equalsIgnoreCase(customerEntity.getEmailAddress())))
				customerEntity.setEmailAddress(updateCustomer.getEmailAddress());
			if(!(updateCustomer.getMobileNo().equalsIgnoreCase(customerEntity.getMobileNo())))
				customerEntity.setMobileNo(updateCustomer.getMobileNo());
			
			customerRepo.save(customerEntity);
			return ResponseEntity.ok("Update Successful");
		}
		//hii i merge 5
		
		//hii merge 6 fetch 
		
		//merge 7
	}
	
	public ResponseEntity<String> loginCustomer(String userName, String password){
		CustomerEntity customerEntity = customerRepo.findByUserNameAndPassword(userName,password);
		if(customerEntity == null)
			return ResponseEntity.ok("login or password is incorrect");
		else
			return ResponseEntity.ok("login successful");
	}
	
	////////////////////////////////
}
