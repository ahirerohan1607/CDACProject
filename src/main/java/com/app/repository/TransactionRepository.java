package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Transaction;

public interface TransactionRepository  extends JpaRepository<Transaction, Long>{



//	@Query("SELECT t FROM Transaction t WHERE t.senderAccount.accountNumber = :accountNumber " +
//            "AND t.transactionDateTime BETWEEN :startDate AND :endDate " +
//            "AND t.amount BETWEEN :startValue AND :endValue")
//    List<Transaction> findByAccountNumberAndTransactionDateBetweenAndTransactionValueBetween(String accountNumber,
//                                                 LocalDateTime startDate, LocalDateTime endDate,
//                                                 Double startValue, Double endValue);
//	
//	@Query("SELECT t FROM Transaction t WHERE t.senderAccount.accountNumber = :accountNumber")
//	List<Transaction> getTransactionsByAccountNumber(@Param("accountNumber") String accountNumber);

}
