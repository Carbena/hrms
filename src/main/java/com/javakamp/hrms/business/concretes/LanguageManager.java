package com.javakamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.abstracts.LanguageService;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessResult;
import com.javakamp.hrms.dataAccess.abstracts.LanguageRepository;
import com.javakamp.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{

	private LanguageRepository languageRepo;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepo) {
		super();
		this.languageRepo = languageRepo;
	}

	@Override
	public Result add(Language language) {
		languageRepo.save(language);
		return new SuccessResult("dil bilgisi eklendi");
	}

	@Override
	public Result update(Language language) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int languageId) {
		// TODO Auto-generated method stub
		return null;
	}

}
