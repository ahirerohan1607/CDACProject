package com.app.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TransactionDto {

	private Long transactionId;
    private String transactionStatus;
    private String transactionType;
    private LocalDateTime transactionDateTime;
    private String fromAccountNumber;
    private String toAccountNumber;
    private double amount;
    private String transactionMode;
}
