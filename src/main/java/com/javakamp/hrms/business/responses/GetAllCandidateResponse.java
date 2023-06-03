package com.javakamp.hrms.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCandidateResponse {
	
	private String email;
	private String firstName;
	private String lastName;
	

}
