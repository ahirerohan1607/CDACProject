package com.app.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.entities.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers", indexes = {@Index(name = "idx_customer_id", columnList = "customerId")})
//@Table(name = "customers")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long customerId;

    @Column(nullable = false)
    protected String firstName;

    @Column(nullable = false)
    protected String lastName;

    @Column(nullable = false, unique = true)
    protected String email;
    
    @Column(nullable = false, unique = true)
    protected String username;
    
    @Column(nullable = false)
    protected String password;
    
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts = new ArrayList<>();

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    protected Address address;
    
  //@Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    //@Column(nullable = false)
    private String phoneNumber;

   // @Column(nullable = false)
    private LocalDate dateOfBirth;


	 //one to one association Employee ----> AdharCard
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	private AdhaarCard adhaarCard;
    
    @Column(nullable = false, unique=true)
    private String panCardNumber;

    
    
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Beneficiary beneficiary;
    
    
	public Customer(String firstName, String lastName, String email, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		//this.userStatus = UserStatus.ACTIVE;
	}
    
 
	






	public void addAccountForUser(Account account) {
    	accounts.add(account);
	}








	
	

}

