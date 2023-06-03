package com.javakamp.hrms.business.abstracts;

import com.javakamp.hrms.business.requests.CreateResumeRequest;
import com.javakamp.hrms.business.responses.GetResumeResponse;
import com.javakamp.hrms.core.utilities.results.DataResult;
import com.javakamp.hrms.core.utilities.results.Result;
import com.javakamp.hrms.entities.concretes.Resume;

public interface ResumeService {
	
	Result add(CreateResumeRequest createResumeRequest);
	Result addTypeResume(Resume resume);
	Result delete(int resumeId);
	Result update(Resume resume);
	DataResult<Resume> getByResumeId(int resumeId);
	DataResult<GetResumeResponse> getById(int resumeId);
	DataResult<GetResumeResponse> getResumeDetailsWithCandidateId(int candidateId);

}
