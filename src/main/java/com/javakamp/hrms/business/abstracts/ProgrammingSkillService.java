package com.javakamp.hrms.business.abstracts;

import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.entities.concretes.ProgrammingSkill;

public interface ProgrammingSkillService {

	Result add(ProgrammingSkill skill);
	Result update(ProgrammingSkill skill);
	Result delete(int skillId);
	
}
