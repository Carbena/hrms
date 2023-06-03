package com.javakamp.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resumes")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Resume {
	
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resume_id")
	private int id;
	
	@Column(name = "posting_date")
	private String date;
	
	@JsonIgnore
	@OneToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "image_id")
	private Image image;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "letter_id")
	private CoverLetter coverLetter;
	

	@OneToMany(cascade = CascadeType.ALL)
	private List<Link> links;
	

	@OneToMany(cascade = CascadeType.ALL)
	private List<Language> languages;
	

	@OneToMany(cascade = CascadeType.ALL)
	private List<Education> education;
	

	@OneToMany(cascade = CascadeType.ALL)
	private List<JobExperience> jobExperinces;
	

	@OneToMany(cascade = CascadeType.ALL)
	private List<ProgrammingSkill> programmingSkills;
}
