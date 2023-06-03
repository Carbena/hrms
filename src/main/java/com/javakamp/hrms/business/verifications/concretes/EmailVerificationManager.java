package com.javakamp.hrms.business.verifications.concretes;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.requests.VerifyEmailRequest;
import com.javakamp.hrms.business.verifications.abstracts.EmailVerificationService;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessResult;
import com.javakamp.hrms.dataAccess.abstracts.EmailVerificationRepository;
import com.javakamp.hrms.dataAccess.abstracts.UserRepository;
import com.javakamp.hrms.entities.concretes.EmailValidation;
import com.javakamp.hrms.entities.concretes.User;

@Service
public class EmailVerificationManager implements EmailVerificationService{
	
	private EmailVerificationRepository emailVerificationRepository;
	private UserRepository userRepository;
	
	@Autowired
	public EmailVerificationManager(EmailVerificationRepository emailVerificationRepository
			,UserRepository userRepository) {
		super();
		this.emailVerificationRepository = emailVerificationRepository;
		this.userRepository = userRepository;
	}

	@Override
	public Result verifyEmail(String mail) {
		
		return new SuccessResult(mail + " adresine dogrulama kodu gonderildi");
	}

	@Override
	public Result verifyAccount(VerifyEmailRequest verifyEmailRequest) {
		User user = userRepository.getReferenceById(verifyEmailRequest.getId());
		this.LogDb(user);
		return new SuccessResult(verifyEmailRequest.getMail() + " mail adresi dogrulandi");
		
	}

	@Override
	public void LogDb(User user) {
		
		LocalDateTime time = LocalDateTime.now();
		EmailValidation validation = new EmailValidation();
		validation.setVerified(true);
		validation.setDate(time.toString());
		validation.setUser(user);
		emailVerificationRepository.save(validation);
		
		
	}

}
