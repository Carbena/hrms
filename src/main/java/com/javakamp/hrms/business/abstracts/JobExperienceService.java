package com.javakamp.hrms.business.abstracts;

import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.entities.concretes.JobExperience;

public interface JobExperienceService {

	Result add(JobExperience jobExperience);
	Result update(JobExperience jobExperience);
	Result delete(int id);
}
