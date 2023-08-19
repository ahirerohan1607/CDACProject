package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.repository.AccountRepository;
import com.app.repository.TransactionRepository;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Autowired
	private TransactionRepository transactionRepo;
	
//	@Autowired
//	private AccountService accountService;
	
	@Autowired
	private AccountRepository accountRepo;
	
//	public void addTransactionRecord(Account senderAccount, Account receiverAccount, double amount, TransactionMode transactionMode) {
//		try {
//			Transaction transaction1 = new Transaction(senderAccount, receiverAccount, amount);
//			Transaction transaction2 = new Transaction(receiverAccount, senderAccount, amount);
//			
//			transaction1.setTransactionMode(transactionMode);
//			transaction2.setTransactionMode(transactionMode);
//			
//			transaction1.setTransactionType(TransactionType.DEBIT);
//			transaction2.setTransactionType(TransactionType.CREDIT);
//			transaction1.setTransactionStatus(TransactionStatus.COMPLETED);
//			transaction2.setTransactionStatus(TransactionStatus.COMPLETED);
//			
//			transactionRepo.save(transaction1);
//			transactionRepo.save(transaction2);
//			
//		}catch(Exception e) {
//			throw new TransactionException("could not add trancation record");
//		}
//		
//	}
//
//	@Override
//	public List<TransactionDto> getAllTransactions(
//            String accountNumber, String startDate, String endDate,
//            Double startValue, Double endValue) {
//		
//		
//		
//		Account account = accountRepo.findByAccountNumber(accountNumber)
//				.orElseThrow(()->new ResourceNotFoundException("account not found "));
//		
//		System.out.println("Before");
//		System.out.println(startDate);
//		System.out.println(endDate);
//		System.out.println(startValue);
//		System.out.println(endDate);
//
//        LocalDate parsedStartDate = startDate != null ? LocalDate.parse(startDate) : account.getOpenDate();
//        
//
//
//        LocalDate parsedEndDate = endDate != null ? LocalDate.parse(endDate) : LocalDate.now();
//        
//        LocalDateTime parsedStartDateTime = parsedStartDate.atStartOfDay();
//        LocalDateTime parsedEndDateTime = parsedEndDate.atTime(23, 59, 59, 999999999);
//
//
//        Double effectiveStartValue = startValue != null ? startValue : 0.0;
//        Double effectiveEndValue = endValue != null ? endValue : Double.MAX_VALUE;
//        
//        
//        
//        
//        System.out.println("After");
//		System.out.println(parsedStartDate);
//		System.out.println(parsedEndDate);
//		System.out.println(effectiveStartValue);
//		System.out.println(effectiveEndValue);
//
//        List<Transaction> transactions = transactionRepo
//            .findByAccountNumberAndTransactionDateBetweenAndTransactionValueBetween(
//                accountNumber, parsedStartDateTime, parsedEndDateTime, effectiveStartValue, effectiveEndValue
//            );
//
//        return transactions.stream()
//            .map(this::convertToDto)
//            .collect(Collectors.toList());
//        
//      
//    }
//
//
//
//
//    private TransactionDto convertToDto(Transaction transaction) {
//        TransactionDto dto = mapper.map(transaction, TransactionDto.class);
//        
//        if (transaction.getSenderAccount() != null) {
//            dto.setFromAccountNumber(transaction.getSenderAccount().getAccountNumber());
//            
//            
//        }
//        
//        if (transaction.getReceiverAccount() != null) {
//            dto.setToAccountNumber(transaction.getReceiverAccount().getAccountNumber());
//        }
//        
//        return dto;
//    }


}
