package com.javakamp.hrms.business.abstracts;

import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.entities.concretes.Education;

public interface EducationService {

	Result add(Education education);
	Result update(Education education);
	Result delete(int educationId);
}
