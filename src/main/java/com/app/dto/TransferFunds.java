package com.app.dto;

import com.app.entities.enums.TransactionMode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransferFunds {

	private String senderAccountNumber;
	private String receiverAccountNumber;
	private double amount;
	private TransactionMode transactionMode;
}
