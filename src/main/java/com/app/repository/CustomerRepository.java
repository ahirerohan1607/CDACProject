package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
//	
//	Optional<Customer> findByUsernameAndPassword(String username, String password);
//	
//	Optional<Customer> findByUsername(String username);
//
//	Optional<Customer> findByAccountsAccountNumber(String accountNumber);

}
