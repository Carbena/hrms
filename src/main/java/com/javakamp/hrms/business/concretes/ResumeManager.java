package com.javakamp.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javakamp.hrms.business.abstracts.ResumeService;
import com.javakamp.hrms.business.requests.CreateResumeRequest;
import com.javakamp.hrms.business.responses.GetResumeResponse;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.ErrorDataResult;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.core.utilities.results.SuccessDataResult;
import com.javakamp.hrms.core.utilities.results.SuccessResult;
import com.javakamp.hrms.dataAccess.abstracts.CandidateRepository;
import com.javakamp.hrms.dataAccess.abstracts.ResumeRepository;
import com.javakamp.hrms.entities.concretes.Resume;

@Service
public class ResumeManager implements ResumeService{

	private ResumeRepository resumeRepo;
	private CandidateRepository candidateRepo;

	

	@Autowired
	public ResumeManager(ResumeRepository resumeRepo, CandidateRepository candidateRepo) {
		super();
		this.resumeRepo = resumeRepo;
		this.candidateRepo = candidateRepo;
	}

	@Override
	public Result add(CreateResumeRequest createResumeRequest) {
		Resume saveItem = new Resume();
		saveItem.setCandidate(candidateRepo.getReferenceById(createResumeRequest.getCandidateId()));
		saveItem.setCoverLetter(createResumeRequest.getCoverLetter());
		saveItem.setDate(createResumeRequest.getDate());
		saveItem.setEducation(createResumeRequest.getEducations());
		saveItem.setImage(createResumeRequest.getImage());
		saveItem.setJobExperinces(createResumeRequest.getJobExperiences());
		saveItem.setLanguages(createResumeRequest.getLanguages());
		saveItem.setLinks(createResumeRequest.getLinks());
		saveItem.setProgrammingSkills(createResumeRequest.getProgrammingSkills());
		
		resumeRepo.save(saveItem);
		
		return new SuccessResult("cv kaydedildi");
	}
	
	@Override
	public Result addTypeResume(Resume resume) {
		resumeRepo.save(resume);
		return new SuccessResult("cv kaydedildi");
	}

	@Override
	public Result delete(int resumeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(Resume resume) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<Resume> getByResumeId(int resumeId){
		return new SuccessDataResult<Resume>(resumeRepo.getReferenceById(resumeId),"cv getirildi");
	}
	
	@Override
	public DataResult<GetResumeResponse> getResumeDetailsWithCandidateId(int candidateId) {
		if(resumeRepo.findByCandidate_Id(candidateId)==null) {
			return new ErrorDataResult<GetResumeResponse>("cv bulunamadi");
		}
		Resume dbItem = resumeRepo.findByCandidate_Id(candidateId);
		
		GetResumeResponse responseItem = new GetResumeResponse(
				dbItem.getCandidate(),
				dbItem.getCoverLetter(), 
				dbItem.getImage(),
				dbItem.getJobExperinces(), 
				dbItem.getLanguages(), 
				dbItem.getLinks(),
				dbItem.getEducation(),
				dbItem.getProgrammingSkills(), 
				dbItem.getDate());
		
		return new SuccessDataResult<GetResumeResponse>(responseItem,"cv listelendi");
		
	}

	@Override
	public DataResult<GetResumeResponse> getById(int resumeId) {
		Resume resume = resumeRepo.getReferenceById(resumeId);
		GetResumeResponse responseItem = new GetResumeResponse();
		responseItem.setCandidate(resume.getCandidate());
		responseItem.setCoverLetter(resume.getCoverLetter());
		responseItem.setDate(resume.getDate());
		responseItem.setEducations(resume.getEducation());
		responseItem.setImage(resume.getImage());
		responseItem.setJobExperiences(resume.getJobExperinces());
		responseItem.setLanguages(resume.getLanguages());
		responseItem.setLinks(resume.getLinks());
		responseItem.setProgrammingSkills(resume.getProgrammingSkills());
		
		return new SuccessDataResult<GetResumeResponse>(responseItem,"cv getirildi");
		
	}

}
