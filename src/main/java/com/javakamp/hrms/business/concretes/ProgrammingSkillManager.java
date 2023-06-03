package com.javakamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.abstracts.ProgrammingSkillService;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessResult;
import com.javakamp.hrms.dataAccess.abstracts.ProgrammingSkillRepository;
import com.javakamp.hrms.entities.concretes.ProgrammingSkill;

@Service
public class ProgrammingSkillManager implements ProgrammingSkillService{

	private ProgrammingSkillRepository progSkillRepo;
	
	@Autowired
	public ProgrammingSkillManager(ProgrammingSkillRepository progSkillRepo) {
		super();
		this.progSkillRepo = progSkillRepo;
	}

	@Override
	public Result add(ProgrammingSkill skill) {
		progSkillRepo.save(skill);
		return new SuccessResult("programlama bilgisi eklendi");
	}

	@Override
	public Result update(ProgrammingSkill skill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int skillId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
