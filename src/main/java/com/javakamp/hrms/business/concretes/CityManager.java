package com.javakamp.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.abstracts.CityService;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessDataResult;
import com.javakamp.hrms.core.utilities.results.SuccessResult;
import com.javakamp.hrms.dataAccess.abstracts.CityRepository;
import com.javakamp.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityRepository cityRepository;
	
	@Autowired
	public CityManager(CityRepository cityRepository) {
		super();
		this.cityRepository = cityRepository;
	}

	@Override
	public Result add(City city) {
		
		cityRepository.save(city);
		return new SuccessResult("sehir basariyla eklendi");
	}

	@Override
	public DataResult<List<City>> getAll() {
		
		return new SuccessDataResult<List<City>>(cityRepository.findAll(),"sehirler listelendi");
	}

}
