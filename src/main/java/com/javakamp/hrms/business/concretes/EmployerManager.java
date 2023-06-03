package com.javakamp.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.abstracts.EmployerService;
import com.javakamp.hrms.business.requests.CreateEmployerRequest;
import com.javakamp.hrms.business.responses.GetAllEmployerResponse;
import com.javakamp.hrms.business.validations.abstracts.ValidationService;
import com.javakamp.hrms.business.verifications.abstracts.EmailVerificationService;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessDataResult;
import com.javakamp.hrms.core.utilities.results.SuccessResult;
import com.javakamp.hrms.dataAccess.abstracts.EmployerRepository;
import com.javakamp.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerRepository employerRepository;
	private ValidationService validationService;
	private EmailVerificationService emailVerificationService;

	@Autowired
	public EmployerManager(EmployerRepository employerRepository,
			ValidationService validationService,
			EmailVerificationService emailVerificationService) {
		super();
		this.employerRepository = employerRepository;
		this.validationService = validationService;
		this.emailVerificationService = emailVerificationService;
	}

	@Override
	public DataResult<List<GetAllEmployerResponse>> getAll() {
		
		List<Employer> employers = employerRepository.findAll();
		List<GetAllEmployerResponse> responseList = new ArrayList<GetAllEmployerResponse>();

		for (Employer listItem : employers) {
			GetAllEmployerResponse responseItem = new GetAllEmployerResponse();
			responseItem.setCompanyName(listItem.getCompanyName());
			responseItem.setWebSite(listItem.getWebSite());
			responseItem.setPhoneNumber(listItem.getPhoneNumber());

			responseList.add(responseItem);
		}

		return new SuccessDataResult<List<GetAllEmployerResponse>>(responseList, "Is Verenler Listelendi");
		
		
	}

	@Override
	public Result add(CreateEmployerRequest createEmployerRequest) {
		
		if (validationService.isCreateEmployerEmpty(createEmployerRequest).isSuccess()) {
			return validationService.isCreateEmployerEmpty(createEmployerRequest);
			
		}else if (!validationService.isPasswordMatches(createEmployerRequest.getPassword(),createEmployerRequest.getRePassword()).isSuccess()) {
			return validationService.isPasswordMatches(createEmployerRequest.getPassword(),createEmployerRequest.getRePassword());

		} else if (validationService.isMailUsed(createEmployerRequest.getMail()).isSuccess()) {
			return validationService.isMailUsed(createEmployerRequest.getMail());
		}

		Employer employer = new Employer();
		employer.setCompanyName(createEmployerRequest.getCompanyName());
		employer.setMail(createEmployerRequest.getMail());
		employer.setPhoneNumber(createEmployerRequest.getPhoneNumber());
		employer.setWebSite(createEmployerRequest.getWebSite());
		employer.setPassword(createEmployerRequest.getPassword());
		employerRepository.save(employer);
		
		return new SuccessResult("Kayit basariyle gerceklesti"
				+ emailVerificationService.verifyEmail(createEmployerRequest.getMail()).getMessage());

	}

}
