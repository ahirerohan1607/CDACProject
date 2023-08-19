package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.RegisterCustomerDto;
import com.app.entities.Account;
import com.app.entities.Address;
import com.app.entities.AdhaarCard;
import com.app.entities.Beneficiary;
import com.app.entities.Customer;
import com.app.entities.Transaction;
import com.app.entities.TransferFundsAccount;
import com.app.entities.enums.AccountStatus;
import com.app.entities.enums.CustomerStatus;
import com.app.entities.enums.TransactionMode;
import com.app.entities.enums.TransactionStatus;
import com.app.entities.enums.TransactionType;
import com.app.repository.AccountRepository;
import com.app.repository.AddressRepository;
import com.app.repository.AdhaarCardRepository;
import com.app.repository.BeneficiaryRepository;
import com.app.repository.CustomerRepository;
import com.app.repository.TransactionRepository;
import com.app.repository.TransferFundsAccountRepository;

@SuppressWarnings("unused")
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private AdhaarCardRepository adhaarCardRepo;
	
	@Autowired
	private BeneficiaryRepository beneficiaryRepo;
	
	@Autowired
	private TransactionRepository transactionRepo;

	@Autowired
	private TransferFundsAccountRepository transferFundsAccountRepo;
	

	@Override
	public String registerCustomer(RegisterCustomerDto registerCustomerDto) {
		
		System.out.println("\n\n\nbefore mapping ");
		System.out.println(registerCustomerDto);
		
		Address address = mapper.map(registerCustomerDto.getAddress(), Address.class);
		AdhaarCard adhaarCard = mapper.map(registerCustomerDto.getAdhaarCard(), AdhaarCard.class);
		Beneficiary beneficiary = mapper.map(registerCustomerDto.getBeneficiary(), Beneficiary.class);
		
		
				
		Customer customer = mapper.map(registerCustomerDto, Customer.class);
		System.out.println("After mapping");
		System.out.println(customer);
		
		
		customer.setAddress(null);
		customer.setAdhaarCard(null);
		customer.setBeneficiary(null);
		customer.setCustomerStatus(CustomerStatus.PENDING_APPROVAL);
		
		System.out.println("After null");
		System.out.println(customer);
		
			
		
		Customer persistentCustomer = customerRepo.save(customer);
		
		address.setCustomer(persistentCustomer);
		adhaarCard.setCustomer(persistentCustomer);
		beneficiary.setCustomer(persistentCustomer);
		
		System.out.println("After save ");
		System.out.println(customer);
		
		System.out.println("After save per ");
		System.out.println(persistentCustomer);
		
		System.out.println("the big three");
		System.out.println(address);
		System.out.println(adhaarCard);
		System.out.println(beneficiary);
		
		

		double deposite = registerCustomerDto.getDeposite();
		Account account = persistentCustomer.createAccountForCustomer(customer, registerCustomerDto.getAccountType(), deposite);
		
		account.setAccountStatus(AccountStatus.PENDING_APPROVAL);
		System.out.println("account 1 ");
		System.out.println(account);
		
		
		if(deposite > 0) {
			TransferFundsAccount tfa = new TransferFundsAccount(account);
			System.out.println(tfa);
			transferFundsAccountRepo.save(tfa);
			
			Transaction transaction = new Transaction(account, tfa, deposite, TransactionMode.CASH, TransactionType.DEPOSIT);
			transaction.setTransactionStatus(TransactionStatus.PENDING);
			//transaction.set
			account.addTransaction(transaction);
			System.out.println(transaction);
			transactionRepo.save(transaction);
		}
		
		System.out.println("account after deposite ");
		System.out.println(account);
		
		System.out.println("\n\n\nAfter mapping "+customer);
		System.out.println("\n\n\nAfter mapping "+persistentCustomer);
		
		persistentCustomer.setAddress(address);
		persistentCustomer.setAdhaarCard(adhaarCard);
		persistentCustomer.setBeneficiary(beneficiary);
		
		return registerCustomerDto.getFirstName()+"'s account with account number "+ account.getAccountNumber() +" has been created!!!!";
	}

//	@Override
//	public String customerLogin(String username, String password) {
//		Customer customer = customerRepo.findByUsernameAndPassword(username, password)
//				.orElseThrow(()->new ResourceNotFoundException("incorrect username or password"));
//		
//		return customer.getFirstName()+" successfully logged in.";
//	}
//
//	@Override
//	public String deleteCustomer(String username) {
//		Customer customer = customerRepo.findByUsername(username)
//				.orElseThrow(()->new ResourceNotFoundException("incorrect username"));
//		//TODO: delect all accounts
//		String message = accountService.deleteAccounts(customer);
//		System.out.println(message);
//		customer.setUserStatus(CustomerStatus.INACTIVE);
//		
//		return customer.getFirstName()+" deleted successfully.";
//	}
//
//	
//
//	@Override
//	public List<CustomerDto> getAllCustomers() {
//		List<Customer> list = customerRepo.findAll();
//		List<CustomerDto> customers = new ArrayList();
//		list.forEach(cust -> customers.add(mapper.map(cust, CustomerDto.class)));
//		
//		customers.forEach(custdto->System.out.println(custdto));
//		return customers;
//	}

//	@Override
//	public String customerLogin(String username, String password) {
//		Customer user = customerRepo.findByUsernameAndPassword(username, password)
//				.orElseThrow(()->new ResourceNotFoundException("incorrect username or password"));
//		return user.getFirstName()+" successfully logged in.";
//	}
//
//	@Override
//	public String deleteCustomer(String username) {
//		Customer user = customerRepo.findByUsername(username)
//				.orElseThrow(()->new ResourceNotFoundException("incorrect username"));
//		customerRepo.delete(user);
//		
//		return user.getFirstName()+" deleted successfully.";
//	}
//
//
//	@Override
//	public Double updateBalance(String username, String accountNumber, double balance) {
//		
//		Customer user = customerRepo.findByUsername(username)
//				.orElseThrow(()->new ResourceNotFoundException("incorrect username"));
//		
//		Account account = accountRepo.findByAccountNumberAndAccountHolder(accountNumber, user)
//				.orElseThrow(()->new ResourceNotFoundException("incorrect account number"));
//		
//		account.setBalance(account.getBalance()-balance);
//		
//		String message =  account.getBalance()+" debited from "+user.getFirstName()+"'s account";
//		
//		System.out.println(message);
//		
//		return account.getBalance();
//	}

}
