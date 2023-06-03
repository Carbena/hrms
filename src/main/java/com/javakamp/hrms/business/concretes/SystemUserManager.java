package com.javakamp.hrms.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.abstracts.SystemUserService;
import com.javakamp.hrms.business.requests.CreateSystemUserRequest;
import com.javakamp.hrms.business.responses.GetAllSystemUserResponse;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessDataResult;
import com.javakamp.hrms.core.utilities.results.SuccessResult;
import com.javakamp.hrms.dataAccess.abstracts.SystemUserRepository;
import com.javakamp.hrms.entities.concretes.SystemUser;

@Service
public class SystemUserManager implements SystemUserService{
	
	private SystemUserRepository sysUserRepo;

	@Autowired
	public SystemUserManager(SystemUserRepository sysUserRepo) {
		super();
		this.sysUserRepo = sysUserRepo;
	}

	@Override
	public DataResult<List<GetAllSystemUserResponse>> getAll() {
		List<SystemUser> sysUsers = sysUserRepo.findAll();
		List<GetAllSystemUserResponse> responseList = new ArrayList<GetAllSystemUserResponse>();
		
		for(SystemUser sysUser : sysUsers) {
			GetAllSystemUserResponse responseItem = new GetAllSystemUserResponse();
			responseItem.setMail(sysUser.getMail());
			responseItem.setFirstName(sysUser.getFirstName());
			responseItem.setLastName(sysUser.getLastName());
			responseList.add(responseItem);
		}
		
		return new SuccessDataResult<List<GetAllSystemUserResponse>>(responseList,"sistem kullanicilari listelendi");
	}

	@Override
	public Result add(CreateSystemUserRequest createSystemUserRequest) {
		SystemUser sysUser = new SystemUser();
		sysUser.setMail(createSystemUserRequest.getMail());
		sysUser.setFirstName(createSystemUserRequest.getFirstName());
		sysUser.setLastName(createSystemUserRequest.getLastName());
		sysUser.setPassword(createSystemUserRequest.getPassword());
		
		sysUserRepo.save(sysUser);
		
		return new SuccessResult(sysUser.getFirstName() + " adli sistem kullanici basariyla kaydedildi");
	}

}
