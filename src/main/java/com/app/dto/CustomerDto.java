package com.app.dto;

import java.time.LocalDate;
import java.util.List;

import com.app.entities.Account;

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
public class CustomerDto {

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String username;
	
	//private List<Account> accounts;
	
	
    private String phoneNumber;

    private LocalDate dateOfBirth;

    
    private String aadharCardNumber;

    
    private String nationality;
}
