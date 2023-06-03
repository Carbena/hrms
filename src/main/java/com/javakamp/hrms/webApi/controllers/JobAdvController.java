package com.javakamp.hrms.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javakamp.hrms.business.concretes.JobAdvManager;
import com.javakamp.hrms.business.requests.CreateJobAdvRequest;
import com.javakamp.hrms.business.responses.GetJobAdvResponse;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessResult;

@RestController
@RequestMapping("/api/jobadv")
public class JobAdvController {

	
	private JobAdvManager jobAdvManager;

	@Autowired
	public JobAdvController(JobAdvManager jobAdvManager) {
		super();
		this.jobAdvManager = jobAdvManager;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateJobAdvRequest jobAdv) {
		jobAdvManager.add(jobAdv);
		return new SuccessResult("is ilani basariyla eklendi");
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<GetJobAdvResponse>> getAll(){
		return jobAdvManager.getAll();
	}
	
	@GetMapping("/getallsortedbydate")
	public DataResult<List<GetJobAdvResponse>> getAllSortedByDate(){
		return jobAdvManager.getAllSortedByDate();
	}
	
	@GetMapping("/getbyemployer")
	public DataResult<List<GetJobAdvResponse>> getByEmployer(int employer) {
		return jobAdvManager.getByEmployer(employer);
	}
	
	@PostMapping("/setinactive")
	public Result setInActiveJobAdv(@RequestBody int jobAdvId) {
		return jobAdvManager.setInActiveJobAdv(jobAdvId);
	}

}
