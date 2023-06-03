package com.javakamp.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.abstracts.JobTitleService;
import com.javakamp.hrms.business.requests.CreateJobTitleRequest;
import com.javakamp.hrms.business.responses.GetAllJobTitleResponse;
import com.javakamp.hrms.business.validations.abstracts.ValidationService;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.ErrorResult;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessDataResult;
import com.javakamp.hrms.core.utilities.results.SuccessResult;
import com.javakamp.hrms.dataAccess.abstracts.JobTitleRepository;
import com.javakamp.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{
	
	private JobTitleRepository jobTitleRepository;
	private ValidationService validationService;

	@Autowired
	public JobTitleManager(JobTitleRepository jobTitleRepository, ValidationService validationService) {
		super();
		this.jobTitleRepository = jobTitleRepository;
		this.validationService = validationService;
	}

	@Override
	public Result add(CreateJobTitleRequest createJobTitleRequest) {
		if(validationService.isJobTitleUsed(createJobTitleRequest.getName()).isSuccess()) {
			return new ErrorResult(validationService.isJobTitleUsed(createJobTitleRequest.getName()).getMessage());
		}
		
		JobTitle jobTitle = new JobTitle();
		jobTitle.setName(createJobTitleRequest.getName());
		
		jobTitleRepository.save(jobTitle);
		
		return new SuccessResult("poziyon basariyla eklendi");
		
	}

	@Override
	public DataResult<List<GetAllJobTitleResponse>> getAll() {
		List<JobTitle> titles = jobTitleRepository.findAll();
		List<GetAllJobTitleResponse> responseList = new ArrayList<GetAllJobTitleResponse>();
		
		for(JobTitle title : titles) {
			GetAllJobTitleResponse responseItem = new GetAllJobTitleResponse();
			responseItem.setName(title.getName());
			responseList.add(responseItem);
		}
		
		return new SuccessDataResult<List<GetAllJobTitleResponse>>(responseList,"pozisyonlar listelendi");
		
		
	}
	
	

}
