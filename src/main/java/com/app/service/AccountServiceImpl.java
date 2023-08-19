package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.repository.AccountRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private TransactionService transactionService;

//	@Override
//	public String deleteAccounts(Customer user) {
//	
//		List<Account> accounts = accountRepo.findByUser(user);
//		
//		accounts.forEach((acc) -> acc.setAccountStatus(AccountStatus.INACTIVE));
////		
//		accountRepo.saveAll(accounts);
//		
//		return "accounts of "+user.getFirstName()+" deleted ";
//	}

//	@Override
//	public Double transferFunds(String senderAccountNumber, String receiverAccountNumber, double amount, TransactionMode transactionMode) {
//		Account sender = accountRepo.findByAccountNumber(senderAccountNumber)
//				.orElseThrow(()->new ResourceNotFoundException("access denied to account"));
//		Account receiver = accountRepo.findByAccountNumber(receiverAccountNumber)
//				.orElseThrow(()->new ResourceNotFoundException("receiver not found "));
//		double min = 0;
//		
////		if(sender instanceof SavingAccount) {
////			SavingAccount senderN = (SavingAccount) sender;
////		}elseIf(sender instanceof CurrentAccount){
////			CurrentAccount senderN = (CurrentAccount) sender;
////		}
//		
//		SavingAccount senderN = (SavingAccount) sender;
//				
//		if(senderN.getBalance() - amount >= SavingAccount.getMinimumBalance() ) {
//			senderN.setBalance(senderN.getBalance() - amount);
//			
//			receiver.setBalance(receiver.getBalance() + amount);
//			
//			senderN.setLastTransactionDate(LocalDate.now());
//			receiver.setLastTransactionDate(LocalDate.now());
//			
//			accountRepo.save(senderN);
//			accountRepo.save(receiver);
//			
//			transactionService.addTransactionRecord(sender, receiver, amount, transactionMode);
//		}else {
//			throw new AccountBalanceException("Not enough balance");
//		}
//			
//		return amount;
//	}

//	@Override
//	public AccountDto getByAccountNumber(String accountNumber) {
//		Account account = accountRepo.findBy(accountNumber)
//				.orElseThrow(()->new ResourceNotFoundException("account not found "));
//		
//		
//		AccountDto accountDto = mapper.map(account, AccountDto.class);
//		
//		System.out.println(accountDto);
//		
//		return accountDto;
//		
//	}
//	
	
	
	

//	@Override
//	public String deposit(TransactionRequestDto transactionRequest) {
//		Account account = accountRepo.findByAccountNumber(transactionRequest.getAccountNumber())
//				.orElseThrow(()->new ResourceNotFoundException("account not found "));	
//		
//		account.setBalance(account.getBalance()+transactionRequest.getAmount());
//		//transactionService.addTransactionRecordDepositeWithdraw(account.getAccountNumber(), transactionRequest.getAmount(), TransactionMode.DEPOSITE);
//		return  account.getAccountNumber() +" is credited by "+transactionRequest.getAmount();
//	}
//
//	@Override
//	public String withdraw(TransactionRequestDto transactionRequest) {
//		
//		Account account = accountRepo.findByAccountNumber(transactionRequest.getAccountNumber())
//				.orElseThrow(()->new ResourceNotFoundException("account not found "));	
//		
//		account.setBalance(account.getBalance()-transactionRequest.getAmount());
//		//transactionService.addTransactionRecordDepositeWithdraw(account.getAccountNumber(), transactionRequest.getAmount(), TransactionMode.WITHDRAW);
//		return  account.getAccountNumber() +" is debited by "+transactionRequest.getAmount();
//	}
//	
//	
//	
//	
//	
//	public Account getAccountByAccountNumberService(String accountNumber) {
//		Account account = accountRepo.findByAccountNumber(accountNumber)
//				.orElseThrow(()->new ResourceNotFoundException("account not found "));
//		
//		
//		
//		return account;
//		
//	}

}


