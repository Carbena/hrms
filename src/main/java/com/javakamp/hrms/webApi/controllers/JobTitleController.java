package com.javakamp.hrms.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javakamp.hrms.business.concretes.JobTitleManager;
import com.javakamp.hrms.business.requests.CreateJobTitleRequest;
import com.javakamp.hrms.business.responses.GetAllJobTitleResponse;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/jobtitles")
public class JobTitleController {
	
	private JobTitleManager jobTitleManager;

	@Autowired
	public JobTitleController(JobTitleManager jobTitleManager) {
		super();
		this.jobTitleManager = jobTitleManager;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateJobTitleRequest createJobTitleRequest) {
		return jobTitleManager.add(createJobTitleRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<GetAllJobTitleResponse>> getAll(){
		return jobTitleManager.getAll();
	}

}
