package com.javakamp.hrms.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javakamp.hrms.business.concretes.SystemUserManager;
import com.javakamp.hrms.business.requests.CreateSystemUserRequest;
import com.javakamp.hrms.business.responses.GetAllSystemUserResponse;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/systemuser")
public class SystemUserController {

	private SystemUserManager systemUserManager; 
	
	@Autowired
	public SystemUserController(SystemUserManager systemUserManager) {
		super();
		this.systemUserManager = systemUserManager;
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllSystemUserResponse>> getAll(){
		return systemUserManager.getAll();
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateSystemUserRequest createSystemUserRequest) {
		return systemUserManager.add(createSystemUserRequest);
	}
}
