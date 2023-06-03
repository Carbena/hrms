package com.javakamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.abstracts.CoverLetterService;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessResult;
import com.javakamp.hrms.dataAccess.abstracts.CoverLetterRepository;
import com.javakamp.hrms.entities.concretes.CoverLetter;

@Service
public class CoverLetterManager implements CoverLetterService{

	private CoverLetterRepository coverLetterRepo;
	
	@Autowired
	public CoverLetterManager(CoverLetterRepository coverLetterRepo) {
		super();
		this.coverLetterRepo = coverLetterRepo;
	}

	@Override
	public Result add(CoverLetter coverLetter) {
		coverLetterRepo.save(coverLetter);
		return new SuccessResult("yazi kaydedildi");
	}

	@Override
	public Result update(CoverLetter coverLetter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int letterId) {
		// TODO Auto-generated method stub
		return null;
	}

}
