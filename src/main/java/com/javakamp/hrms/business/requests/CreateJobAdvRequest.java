package com.javakamp.hrms.business.requests;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateJobAdvRequest {

	
	private String description;
	
	private int minSal;
	
	private int maxSal;
	
	private int jobPoz;
	
	private Date deadline;
		
	private int cityId;

	private int jobTitleId;
	
	private int employerId;
	

}
