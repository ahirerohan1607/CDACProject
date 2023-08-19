package com.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private AccountService accountService;

	
	
//	@GetMapping("/details/{accountNumber}")
//	public ResponseEntity<?> getAccountDetails(@PathVariable String accountNumber) {
//		try {
//
//			return new ResponseEntity<>(accountService.getByAccountNumber(accountNumber), HttpStatus.OK);
//		} catch (RuntimeException e) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponce(e.getMessage()));
//		}
//
//	}
//	
//	@PostMapping("/deposit")
//    public ResponseEntity<String> deposit(@RequestBody TransactionRequestDto transactionRequest) {
//        accountService.deposit(transactionRequest);
//        return ResponseEntity.status(HttpStatus.OK).body("Deposit successful");
//    }
//
//    @PostMapping("/withdraw")
//    public ResponseEntity<String> withdraw(@RequestBody TransactionRequestDto transactionRequest) {
//        accountService.withdraw(transactionRequest);
//        return ResponseEntity.status(HttpStatus.OK).body("Withdrawal successful");
//    }
//    
//    @PostMapping("/trasaction/send")
//	public ResponseEntity<?> transferFundsfer(@RequestBody TransferFunds request) {
//		try {
//			String senderAccountNumber = request.getSenderAccountNumber();
//			String receiverAccountNumber = request.getReceiverAccountNumber();
//			double amount = request.getAmount();
//			TransactionMode trasactionMode = request.getTransactionMode();
//			//System.out.println("in get students by course "+courseTitle);
//			return new ResponseEntity<>(new ApiResponce(accountService.transferFunds(senderAccountNumber, receiverAccountNumber, amount, trasactionMode)+" debited"), HttpStatus.OK);
//			
//		} catch (RuntimeException e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponce(e.getMessage()));
//		}
//
//	}
}
