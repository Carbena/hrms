package com.javakamp.hrms.business.abstracts;

import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.entities.concretes.Link;

public interface LinkService {

	Result add(Link link);
	Result update(Link link);
	Result delete(int linkId);
}
