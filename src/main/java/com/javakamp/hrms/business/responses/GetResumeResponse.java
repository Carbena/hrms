package com.javakamp.hrms.business.responses;

import java.util.List;

import com.javakamp.hrms.entities.concretes.Candidate;
import com.javakamp.hrms.entities.concretes.CoverLetter;
import com.javakamp.hrms.entities.concretes.Education;
import com.javakamp.hrms.entities.concretes.Image;
import com.javakamp.hrms.entities.concretes.JobExperience;
import com.javakamp.hrms.entities.concretes.Language;
import com.javakamp.hrms.entities.concretes.Link;
import com.javakamp.hrms.entities.concretes.ProgrammingSkill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetResumeResponse {
	
	private Candidate candidate;
	
	private CoverLetter coverLetter;
	
	private Image image;
	
	private List<JobExperience> jobExperiences;
	
	private List<Language> languages;
	
	private List<Link> links;
	
	private List<Education> educations;
	
	private List<ProgrammingSkill> programmingSkills;
	
	private String date;

}
