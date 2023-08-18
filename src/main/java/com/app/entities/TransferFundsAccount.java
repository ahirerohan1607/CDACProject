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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.entities.enums.Status;
import com.app.entities.enums.TransactionStatus;
import com.app.entities.enums.BeneficiaryBankName;
import com.app.utils.AccountUtils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "transfer_funnds_accounts", indexes = {@Index(name = "idx_account_number", columnList = "accountNumber")})
//@Table(name = "transfer_funnds_accounts")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TransferFundsAccount implements Serializable{
	
	@Id
	@Column(nullable = false, unique = true)
	private String accountNumber;
	
	@Column
	private String accountHolderName;

	@Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BeneficiaryBankName beneficiaryBankName;
	
	@Column
	private int IFSCCode;


}




