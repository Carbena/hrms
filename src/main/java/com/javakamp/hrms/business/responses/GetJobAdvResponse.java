package com.javakamp.hrms.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetJobAdvResponse {
	
	private String jobTitle;

	private String description;
		
	private int jobPoz;
	
	private String deadline;
		
	private String city;

	private String employer;

}
