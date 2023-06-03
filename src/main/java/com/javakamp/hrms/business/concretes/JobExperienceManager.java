package com.javakamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.abstracts.JobExperienceService;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessResult;
import com.javakamp.hrms.dataAccess.abstracts.JobExperienceRepository;
import com.javakamp.hrms.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService{

	private JobExperienceRepository jobExperinceRepo;
	
	@Autowired
	public JobExperienceManager(JobExperienceRepository jobExperinceRepo) {
		super();
		this.jobExperinceRepo = jobExperinceRepo;
	}

	@Override
	public Result add(JobExperience jobExperience) {
		jobExperinceRepo.save(jobExperience);
		return new SuccessResult("is tecrubesi kaydedildi");
	}

	@Override
	public Result update(JobExperience jobExperience) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
