package com.app.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.entities.enums.TransactionMode;
import com.app.entities.enums.TransactionStatus;
import com.app.entities.enums.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@Table(name = "transactions", indexes = {@Index(name = "idx_transaction_id", columnList = "transactionId")})

//@Table(name = "transactions")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    
    @Column(nullable = false)
    private LocalDateTime transactionDateTime;
//    
//    @ManyToOne
//    @JoinColumn(name = "fromAccountNumber")
//    private Account fromAccount;
//    
//    @ManyToOne
//    @JoinColumn(name = "toAccountNumber")
//    private Account toAccount;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "from_account_number")
	private Account fromAccount;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "to_account_number")
	private TransferFundsAccount toAccount;

    
    

    
    @Column(nullable = false)
    private double amount;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionMode transactionMode;

	public Transaction(Account fromAccount, TransferFundsAccount toAccount, double amount) {
		super();
		this.transactionDateTime = LocalDateTime.now();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
				
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionStatus=" + transactionStatus
				+ ", transactionType=" + transactionType + ", transactionDateTime=" + transactionDateTime + ", amount="
				+ amount + ", transactionMode=" + transactionMode + "]";
	}

	public Transaction(Account account, TransferFundsAccount tfa, double deposite, TransactionMode transactionMode, TransactionType transactionType) {
		this(account, tfa, deposite);
		this.transactionMode = transactionMode;
		this.transactionType = transactionType;
	}
	
	
	

	
	
	
    
    
 
}

