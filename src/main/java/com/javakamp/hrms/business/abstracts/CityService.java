package com.javakamp.hrms.business.abstracts;

import java.util.List;

import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.entities.concretes.City;

public interface CityService {
	
	Result add(City city);
	DataResult<List<City>> getAll();

}
