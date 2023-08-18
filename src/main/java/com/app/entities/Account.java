package com.app.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.entities.enums.Status;
import com.app.utils.AccountUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "accountsFromCDACProject", indexes = {@Index(name = "idx_account_number", columnList = "accountNumber")})
//@Table(name = "accounts")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Account implements Serializable{
	
	@Id
	@Column(nullable = false, unique = true)
	private String accountNumber;
	
//	@Version
//	private Long versionId;
	
	@Column(nullable = false)
	private double balance;

    @Column(nullable = false)
    private LocalDate openDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
    
    
    @OneToMany(mappedBy = "fromAccount", cascade = CascadeType.ALL, orphanRemoval = true /* , fetch = FetchType.EAGER */ )
	private List<Transaction> transactions = new ArrayList<>();


    private LocalDate lastTransactionDate;

	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	
	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
	private DebitCard debitCard;
	
	 
	
	
	@OneToOne(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
	private Loan loan;
	
	public Account(Customer customer) {
		super();
		this.accountNumber = AccountUtils.generateAccountNumber();
		this.openDate = LocalDate.now();		
		this.customer = customer;
	}

	public Account(Customer customer, double deposit) {
		super();
		this.accountNumber = AccountUtils.generateAccountNumber();
		this.openDate = LocalDate.now();
		this.customer = customer;
		balance = deposit;
		this.lastTransactionDate = LocalDate.now();
	}



	public Account(Customer customer, String accountNumber, double balance, LocalDate openDate) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.openDate = openDate;
		this.customer = customer;
	}


}




