package com.javakamp.hrms.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCandidateRequest {
	
	private String email;
	private String password;
	private String rePassword;
	private String firstName;
	private String lastName;
	private String nationalityId;
	private String bithYear;
	

}
