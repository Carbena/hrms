package com.javakamp.hrms.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javakamp.hrms.business.abstracts.ResumeService;
import com.javakamp.hrms.business.requests.CreateResumeRequest;
import com.javakamp.hrms.business.responses.GetResumeResponse;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.entities.concretes.Resume;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

	private ResumeService resumeService;

	@Autowired
	public ResumeController(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
		
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateResumeRequest createResumeRequest) {
		
		return resumeService.add(createResumeRequest);
		
	}
	
	@GetMapping("/getbycandidateid")
	public DataResult<GetResumeResponse> getByCandidateId(int candidateId){
		return resumeService.getResumeDetailsWithCandidateId(candidateId);
	}
	
	@PostMapping("/addTypeResume")
	public Result addTypeResume(@RequestBody Resume resume) {
		return resumeService.addTypeResume(resume);
	}
	
	@GetMapping("/getByResumeId")
	public DataResult<Resume> getByResumeId(int resumeId){
		return resumeService.getByResumeId(resumeId);
	}
	
	
	
}
