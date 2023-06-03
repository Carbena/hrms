package com.javakamp.hrms.business.verifications.concretes;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.verifications.abstracts.MernisVerificationService;
import com.javakamp.hrms.dataAccess.abstracts.MernisValidationRepository;
import com.javakamp.hrms.entities.concretes.Candidate;
import com.javakamp.hrms.entities.concretes.MernisValidation;

@Service
public class MernisVerificationManager implements MernisVerificationService {

	private MernisValidationRepository mernisValidationRepository;

	@Autowired
	public MernisVerificationManager(MernisValidationRepository mernisValidationRepository) {
		super();
		this.mernisValidationRepository = mernisValidationRepository;
	}

	@Override
	public void LogDb(Candidate candidate) {

		LocalDateTime time = LocalDateTime.now();
		MernisValidation validation = new MernisValidation();
		validation.setVerified(true);
		validation.setDate(time.toString());
		validation.setCandidate(candidate);
		mernisValidationRepository.save(validation);

	}

}
