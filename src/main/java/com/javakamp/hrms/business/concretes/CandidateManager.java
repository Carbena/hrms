package com.javakamp.hrms.business.concretes;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.abstracts.CandidateService;
import com.javakamp.hrms.business.requests.CreateCandidateRequest;
import com.javakamp.hrms.business.responses.GetAllCandidateResponse;
import com.javakamp.hrms.business.validations.abstracts.ValidationService;
import com.javakamp.hrms.business.verifications.abstracts.EmailVerificationService;
import com.javakamp.hrms.business.verifications.abstracts.MernisVerificationService;
import com.javakamp.hrms.core.adapters.MernisCheckService;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessDataResult;
import com.javakamp.hrms.core.utilities.results.SuccessResult;
import com.javakamp.hrms.dataAccess.abstracts.CandidateRepository;
import com.javakamp.hrms.dataAccess.abstracts.MernisValidationRepository;
import com.javakamp.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateRepository candidateRepository;
	private MernisCheckService mernisCheckService;
	private EmailVerificationService emailVerificationService;
	private MernisVerificationService mernisVerificationService;
	private ValidationService validationService;

	@Autowired
	public CandidateManager(CandidateRepository candidateRepository, MernisCheckService mernisCheckService,
			EmailVerificationService emailVerificationService, MernisValidationRepository mernisValidationRepository,
			MernisVerificationService mernisVerificationService, ValidationService validationService) {

		super();
		this.candidateRepository = candidateRepository;
		this.mernisCheckService = mernisCheckService;
		this.emailVerificationService = emailVerificationService;
		this.mernisVerificationService = mernisVerificationService;
		this.validationService = validationService;
	}

	@Override
	public DataResult<List<GetAllCandidateResponse>> getAll() {

		List<Candidate> candidates = candidateRepository.findAll();
		List<GetAllCandidateResponse> responseList = new ArrayList<GetAllCandidateResponse>();

		for (Candidate listItem : candidates) {
			GetAllCandidateResponse responseItem = new GetAllCandidateResponse();
			responseItem.setEmail(listItem.getMail());
			responseItem.setFirstName(listItem.getFirstName());
			responseItem.setLastName(listItem.getLastName());

			responseList.add(responseItem);
		}

		return new SuccessDataResult<List<GetAllCandidateResponse>>(responseList, "Is Arayanlar Listelendi");
	}

	@Override
	public Result add(CreateCandidateRequest createCandidateRequest) throws NumberFormatException, RemoteException {
		if (!validationService.isPasswordMatches(createCandidateRequest.getPassword(),createCandidateRequest.getRePassword()).isSuccess()) {
			return validationService.isPasswordMatches(createCandidateRequest.getPassword(),createCandidateRequest.getRePassword());

		} else if (validationService.isMailUsed(createCandidateRequest.getEmail()).isSuccess()) {
			return validationService.isMailUsed(createCandidateRequest.getEmail());

		} else if (validationService.isNationalityUsed(createCandidateRequest.getNationalityId()).isSuccess()) {
			return validationService.isNationalityUsed(createCandidateRequest.getNationalityId());

		} else if (!mernisCheckService.MernisCheck(createCandidateRequest).isSuccess()) {
			return mernisCheckService.MernisCheck(createCandidateRequest);

		} else if (validationService.isCreateCandidateEmpty(createCandidateRequest).isSuccess()) {
			return validationService.isCreateCandidateEmpty(createCandidateRequest);
		}

		Candidate candidate = new Candidate();
		candidate.setMail(createCandidateRequest.getEmail());
		candidate.setPassword(createCandidateRequest.getPassword());
		candidate.setFirstName(createCandidateRequest.getFirstName());
		candidate.setLastName(createCandidateRequest.getLastName());
		candidate.setNationalityId(createCandidateRequest.getNationalityId());
		candidate.setBirthYear(createCandidateRequest.getBithYear());
		candidateRepository.save(candidate);
		mernisVerificationService.LogDb(candidate);

		return new SuccessResult("Kayit basariyle gerceklesti"
				+ emailVerificationService.verifyEmail(createCandidateRequest.getEmail()).getMessage());

	}
}
