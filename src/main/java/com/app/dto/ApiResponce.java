package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class ApiResponce {
	
	private String message;
	
	private LocalDateTime timestamp;

	public ApiResponce(String message) {
		super();
		this.message = message;
		timestamp = LocalDateTime.now();
	}
	
	

}
