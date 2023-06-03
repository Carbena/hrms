package com.javakamp.hrms.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javakamp.hrms.business.concretes.EmployerManager;
import com.javakamp.hrms.business.requests.CreateEmployerRequest;
import com.javakamp.hrms.business.responses.GetAllEmployerResponse;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {
	
	private EmployerManager employerManager;

	@Autowired
	public EmployerController(EmployerManager employerManager) {
		super();
		this.employerManager = employerManager;
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllEmployerResponse>> getAll(){
		return employerManager.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateEmployerRequest createEmployerRequest) {
		
		return employerManager.add(createEmployerRequest);
	}
}
