package com.bankmanagement.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankmanagement.customer.entity.CustomerEntity;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer>{
	
	CustomerEntity findByUserName(String userName);

	CustomerEntity findByUserNameAndPassword(String userName, String password);
}
