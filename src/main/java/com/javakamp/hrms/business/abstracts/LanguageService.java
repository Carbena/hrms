package com.javakamp.hrms.business.abstracts;

import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.entities.concretes.Language;

public interface LanguageService {

	Result add(Language language);
	Result update(Language language);
	Result delete(int languageId);
}
