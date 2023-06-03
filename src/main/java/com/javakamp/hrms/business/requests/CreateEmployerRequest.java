package com.javakamp.hrms.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployerRequest {

	private String companyName;
	private String mail;
	private String webSite;
	private String phoneNumber;
	private String password;
	private String rePassword;
}
