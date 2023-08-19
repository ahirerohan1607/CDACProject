package com.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponce;
import com.app.dto.RegisterCustomerDto;
import com.app.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<?> addCustomer(@RequestBody RegisterCustomerDto registerCustomerDto){
		try {
						
			ApiResponce responce = new ApiResponce(customerService.registerCustomer(registerCustomerDto));
			return new ResponseEntity<>(responce, HttpStatus.CREATED);
			
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponce(e.getMessage()));
		}
	}
	
	@GetMapping("/login")
	public ResponseEntity<?> customerLogin(@RequestParam String username, @RequestParam String password) {
		try {

			//System.out.println("in get students by course "+courseTitle);
			return new ResponseEntity<>( HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponce(e.getMessage()));
		}

	}
	
	@DeleteMapping("/delete/")
	public ResponseEntity<?> deleteCustomer(@RequestParam String username) {
		try {

			//System.out.println("in get students by course "+courseTitle);
			return new ResponseEntity<>( HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponce(e.getMessage()));
		}

	}
	
	@GetMapping("/list")
	public ResponseEntity<?> getAllCustomers() {
		try {

			return new ResponseEntity<>( HttpStatus.OK);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponce(e.getMessage()));
		}

	}
	

}
