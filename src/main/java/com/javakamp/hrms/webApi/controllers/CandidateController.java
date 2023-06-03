package com.javakamp.hrms.webApi.controllers;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javakamp.hrms.business.concretes.CandidateManager;
import com.javakamp.hrms.business.requests.CreateCandidateRequest;
import com.javakamp.hrms.business.responses.GetAllCandidateResponse;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
	
	private CandidateManager candidateManager;

	@Autowired
	public CandidateController(CandidateManager candidateManager) {
		super();
		this.candidateManager = candidateManager;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CreateCandidateRequest createCandidateRequest) throws NumberFormatException, RemoteException {
		return this.candidateManager.add(createCandidateRequest);
	}
	
	@GetMapping("/getall")
	public DataResult<List<GetAllCandidateResponse>> getAll(){
		return this.candidateManager.getAll();
	}

}
