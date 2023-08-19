package com.app.controller;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponce;
import com.app.dto.TransactionDto;
import com.app.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllTransactions(
            @RequestParam(required = false) String accountNumber,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate,
            @RequestParam(required = false) Double startValue,
            @RequestParam(required = false) Double endValue) {
		try {

			return new ResponseEntity<>(null);
			//return new ResponseEntity<>(transactionService.getAllTransactions(accountNumber, startDate, endDate, startValue, endValue), HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponce(e.getMessage()));
		}

	}

}
