package com.javakamp.hrms.business.abstracts;

import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {
	
	Result add(CoverLetter coverLetter);
	Result update(CoverLetter coverLetter);
	Result delete(int letterId);

}
