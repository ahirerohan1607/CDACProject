package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Account;

public interface AccountRepository extends JpaRepository<Account, String>{

//
//	Optional<Account> findByAccountNumberAndUser(String accountNumber, Customer user);
//
//	
//	List<Account> findByUser(User user);
//
//
//	Optional<Account> findByAccountNumber(String senderAccountNumber);
	


}
