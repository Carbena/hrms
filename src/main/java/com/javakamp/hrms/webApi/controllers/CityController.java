package com.javakamp.hrms.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javakamp.hrms.business.concretes.CityManager;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/city")
public class CityController {
	
	private CityManager cityManager;
	
	@Autowired
	public CityController(CityManager cityManager) {
		super();
		this.cityManager = cityManager;
	}

	@PostMapping("/add")
	public Result add(@RequestBody City city) {
		return cityManager.add(city);
	}
	
	@GetMapping("/getall")
	public DataResult<List<City>> getAll(){
		return cityManager.getAll();
	}

}
