package com.javakamp.hrms.business.validations.concretes;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.requests.CreateCandidateRequest;
import com.javakamp.hrms.business.requests.CreateEmployerRequest;
import com.javakamp.hrms.business.validations.abstracts.ValidationService;
import com.javakamp.hrms.core.utilities.results.ErrorResult;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessResult;
import com.javakamp.hrms.dataAccess.abstracts.CandidateRepository;
import com.javakamp.hrms.dataAccess.abstracts.JobTitleRepository;
import com.javakamp.hrms.dataAccess.abstracts.UserRepository;
import com.javakamp.hrms.entities.concretes.Candidate;
import com.javakamp.hrms.entities.concretes.JobTitle;
import com.javakamp.hrms.entities.concretes.User;


@Service
public class ValidationManager implements ValidationService{

	private UserRepository userRepository;
	private CandidateRepository candidateRepository;
	private JobTitleRepository jobTitleRepository;
	
	@Autowired
	public ValidationManager(UserRepository userRepository,
			CandidateRepository candidateRepository,
			JobTitleRepository jobTitleRepository) {
		super();
		this.userRepository = userRepository;
		this.candidateRepository = candidateRepository;
		this.jobTitleRepository = jobTitleRepository;
	}

	@Override
	public Result isMailUsed(String mail) {
		List<User> users = userRepository.findAll();
		for(User user : users) {
			if(user.getMail().equals(mail)) {
				return new SuccessResult("mail adresi sistemde kayitli");
			}
		}
		return new ErrorResult();
	}

	@Override
	public Result isNationalityUsed(String nationality) {
		List<Candidate> candidates = candidateRepository.findAll();
		for(Candidate candidate : candidates) {
			if(candidate.getNationalityId().equals(nationality)) {
				return new SuccessResult("kimlik no sistemde kayitli");
			}
		}
		
		return new ErrorResult();
	}

	@Override
	public Result isCreateCandidateEmpty(CreateCandidateRequest candidateRequest) {
		
		if(candidateRequest.getFirstName().isEmpty()
				|| candidateRequest.getLastName().isEmpty()
				|| candidateRequest.getNationalityId().isEmpty()
				|| candidateRequest.getPassword().isEmpty()
				|| candidateRequest.getRePassword().isEmpty()
				|| candidateRequest.getBithYear().isEmpty()
				|| candidateRequest.getEmail().isEmpty()) 
		{
			return new SuccessResult("girilen bilgiler bos olamaz");
		}
		
		return new ErrorResult();
	}
	
	

	@Override
	public Result isPasswordMatches(String password, String rePassword) {
		if(password.equals(rePassword)) {
			return new SuccessResult();
		}
		return new ErrorResult("Sifreler uyumlu degil");
	}

	@Override
	public Result isCompanyMatchesMail(CreateEmployerRequest createEmployerRequest) throws URISyntaxException {
	 
			URI uri = new URI(createEmployerRequest.getWebSite());
			String host = uri.getHost();
			String domain = host.startsWith("www.") ? host.substring(4) : host;
			
			String mailDomain = createEmployerRequest.getMail()
					.substring(createEmployerRequest.getMail().indexOf("@")+ 1 );
			
			if(domain == mailDomain) {
				return new SuccessResult();
			}
			
			return new ErrorResult("mail adresi ile web site domaini uyusmuyor");
			
		
	}

	@Override
	public Result isCreateEmployerEmpty(CreateEmployerRequest createEmployerRequest) {
		
		if(createEmployerRequest.getCompanyName().isEmpty()
				|| createEmployerRequest.getPhoneNumber().isEmpty()
				|| createEmployerRequest.getWebSite().isEmpty()
				|| createEmployerRequest.getPassword().isEmpty()
				|| createEmployerRequest.getRePassword().isEmpty()
				|| createEmployerRequest.getMail().isEmpty()) 
		{
			return new SuccessResult("girilen bilgiler bos olamaz");
		}
		
		return new ErrorResult();
	}

	@Override
	public Result isJobTitleUsed(String title) {
		List<JobTitle> titles = jobTitleRepository.findAll();
		for(JobTitle jobTitle : titles) {
			if(jobTitle.getName().equals(title)) {
				return new SuccessResult("is pozisyonu sistemde kayitli");
			}
		}
		
		return new ErrorResult();
	}

}
