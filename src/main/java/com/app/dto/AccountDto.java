package com.app.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.app.entities.enums.AccountStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountDto implements Serializable {
    
    private String accountNumber;
    private double balance;
    private LocalDate openDate;
    private AccountStatus accountStatus;
    private LocalDate lastTransactionDate;
    //private User user;

    // Constructors, getters, setters, and other methods
}
