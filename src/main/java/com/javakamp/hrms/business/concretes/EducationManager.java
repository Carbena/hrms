package com.javakamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.abstracts.EducationService;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessResult;
import com.javakamp.hrms.dataAccess.abstracts.EducationRepository;
import com.javakamp.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService{

	private EducationRepository eduRepo;
	
	@Autowired
	public EducationManager(EducationRepository eduRepo) {
		super();
		this.eduRepo = eduRepo;
	}

	@Override
	public Result add(Education education) {
		eduRepo.save(education);
		return new SuccessResult("egitim bilgileri kaydedildi");
	}

	@Override
	public Result update(Education education) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int educationId) {
		// TODO Auto-generated method stub
		return null;
	}

}
