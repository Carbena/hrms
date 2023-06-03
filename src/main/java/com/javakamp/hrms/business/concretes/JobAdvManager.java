package com.javakamp.hrms.business.concretes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.abstracts.JobAdvService;
import com.javakamp.hrms.business.requests.CreateJobAdvRequest;
import com.javakamp.hrms.business.responses.GetJobAdvResponse;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessDataResult;
import com.javakamp.hrms.core.utilities.results.SuccessResult;
import com.javakamp.hrms.dataAccess.abstracts.CityRepository;
import com.javakamp.hrms.dataAccess.abstracts.EmployerRepository;
import com.javakamp.hrms.dataAccess.abstracts.JobAdvRepository;
import com.javakamp.hrms.dataAccess.abstracts.JobTitleRepository;
import com.javakamp.hrms.entities.concretes.JobAdv;

@Service
public class JobAdvManager implements JobAdvService{

	private JobAdvRepository jobAdvRepository;
	private CityRepository cityRepository;
	private JobTitleRepository jobTitleRepository;
	private EmployerRepository employerRepository;
	
	@Autowired
	public JobAdvManager(JobAdvRepository jobAdvRepository, CityRepository cityRepository,
			JobTitleRepository jobTitleRepository, EmployerRepository employerRepository) {
		super();
		this.jobAdvRepository = jobAdvRepository;
		this.cityRepository = cityRepository;
		this.jobTitleRepository = jobTitleRepository;
		this.employerRepository = employerRepository;
	}

	@Override
	public Result add(CreateJobAdvRequest jobAdv) {
		JobAdv addItem = new JobAdv();
		addItem.setDescription(jobAdv.getDescription());
		addItem.setMinSal(jobAdv.getMinSal());
		addItem.setMaxSal(jobAdv.getMaxSal());
		addItem.setJobPoz(jobAdv.getJobPoz());
		addItem.setActive(true);
		addItem.setCity(cityRepository.getReferenceById(jobAdv.getCityId()));
		addItem.setJobTitle(jobTitleRepository.getReferenceById(jobAdv.getJobTitleId()));
		addItem.setEmployer(employerRepository.getReferenceById(jobAdv.getEmployerId()));
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		addItem.setDeadline(df.format(jobAdv.getDeadline()));
		
		jobAdvRepository.save(addItem);
	
		return new SuccessResult("is ilani kaydedildi");
	}

	@Override
	public DataResult<List<GetJobAdvResponse>> getAll() {
		
		List<JobAdv> advList = jobAdvRepository.findAll();
		List<GetJobAdvResponse> responseList = new ArrayList<GetJobAdvResponse>();
		
		for (JobAdv listItem : advList) {
			GetJobAdvResponse responseItem = new GetJobAdvResponse();
			responseItem.setJobTitle(listItem.getJobTitle().getName());
			responseItem.setEmployer(listItem.getEmployer().getCompanyName());
			responseItem.setJobPoz(listItem.getJobPoz());
			responseItem.setDeadline(listItem.getDeadline());
			responseItem.setCity(listItem.getCity().getName());
			responseItem.setDescription(listItem.getDescription());
			responseList.add(responseItem);
			
		}
		
		
		return new SuccessDataResult<List<GetJobAdvResponse>>(responseList,
				"is ilanlari listelendi");
	}

	@Override
	public DataResult<List<GetJobAdvResponse>> getAllSortedByDate() {
		Sort sort = Sort.by(Sort.Direction.ASC,"deadline");
		
		List<JobAdv> advList = jobAdvRepository.findAll(sort);
		List<GetJobAdvResponse> responseList = new ArrayList<GetJobAdvResponse>();
		
		for (JobAdv listItem : advList) {
			GetJobAdvResponse responseItem = new GetJobAdvResponse();
			responseItem.setJobTitle(listItem.getJobTitle().getName());
			responseItem.setEmployer(listItem.getEmployer().getCompanyName());
			responseItem.setJobPoz(listItem.getJobPoz());
			responseItem.setDeadline(listItem.getDeadline());
			responseItem.setCity(listItem.getCity().getName());
			responseItem.setDescription(listItem.getDescription());
			responseList.add(responseItem);
			
		}
		
		
		return new SuccessDataResult<List<GetJobAdvResponse>>(responseList,
				"is ilanlari listelendi");
	}

	@Override
	public DataResult<List<GetJobAdvResponse>> getByEmployer(int employer) {
		
		List<JobAdv> advList = jobAdvRepository.getByEmployer_id(employer);
		List<GetJobAdvResponse> responseList = new ArrayList<GetJobAdvResponse>();
		
		for (JobAdv listItem : advList) {
			GetJobAdvResponse responseItem = new GetJobAdvResponse();
			responseItem.setJobTitle(listItem.getJobTitle().getName());
			responseItem.setEmployer(listItem.getEmployer().getCompanyName());
			responseItem.setJobPoz(listItem.getJobPoz());
			responseItem.setDeadline(listItem.getDeadline());
			responseItem.setCity(listItem.getCity().getName());
			responseItem.setDescription(listItem.getDescription());
			responseList.add(responseItem);
			
		}
		
		
		return new SuccessDataResult<List<GetJobAdvResponse>>(responseList,
				"is ilanlari listelendi");
	}

	@Override
	public Result setInActiveJobAdv(int jobAdvId) {
		JobAdv updateItem = jobAdvRepository.getReferenceById(jobAdvId);
		updateItem.setActive(false);
		jobAdvRepository.save(updateItem);
		return new SuccessResult("Ilan pasif duruma gecirildi");
	}

}
