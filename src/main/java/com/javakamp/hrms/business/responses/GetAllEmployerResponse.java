package com.javakamp.hrms.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployerResponse {
	
	private String companyName;
	private String webSite;
	private String phoneNumber;


}
