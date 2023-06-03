package com.javakamp.hrms.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSystemUserRequest {
	
	private String firstName;
	private String lastName;
	private String mail;
	private String password;

}
