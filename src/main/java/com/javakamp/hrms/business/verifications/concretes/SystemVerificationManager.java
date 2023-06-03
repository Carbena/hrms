package com.javakamp.hrms.business.verifications.concretes;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.requests.VerifySystemRequest;
import com.javakamp.hrms.business.verifications.abstracts.SystemVerificationService;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessResult;
import com.javakamp.hrms.dataAccess.abstracts.EmployerRepository;
import com.javakamp.hrms.dataAccess.abstracts.SystemUserRepository;
import com.javakamp.hrms.dataAccess.abstracts.SystemVerificationRepository;
import com.javakamp.hrms.entities.concretes.Employer;
import com.javakamp.hrms.entities.concretes.SystemUser;
import com.javakamp.hrms.entities.concretes.SystemVerification;

@Service
public class SystemVerificationManager implements SystemVerificationService{
	
	private SystemVerificationRepository sysvrifyrepo;
	private EmployerRepository employerRepo;
	private SystemUserRepository sysUserRepo;


	@Autowired
	public SystemVerificationManager(SystemVerificationRepository sysvrifyrepo, EmployerRepository employerRepo,
			SystemUserRepository sysUserRepo) {
		super();
		this.sysvrifyrepo = sysvrifyrepo;
		this.employerRepo = employerRepo;
		this.sysUserRepo = sysUserRepo;
	}



	@Override
	public void logDb(SystemVerification systemVerification) {
		sysvrifyrepo.save(systemVerification);
		
	}

	

	@Override
	public Result verifyAccount(VerifySystemRequest verifySystemRequest) {
		SystemVerification sys = new SystemVerification();
		Employer employer = employerRepo.getReferenceById(verifySystemRequest.getUserId());
		SystemUser sysUser = sysUserRepo.getReferenceById(verifySystemRequest.getSystemUserId());
		LocalDateTime time = LocalDateTime.now();
		
		sys.setDate(time.toString());
		sys.setSystemUser(sysUser);
		sys.setEmployer(employer);
		sys.setVerified(true);
		
		this.logDb(sys);
		
		return new SuccessResult(employer.getMail() + " hesabi sistem tarafindan dogrulandi");
		
		
		
	}

	
}
