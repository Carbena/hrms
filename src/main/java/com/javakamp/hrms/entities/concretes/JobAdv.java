package com.javakamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_adv")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","products"})
public class JobAdv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_adv_id")
	private int jobAdvId;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "salary_min")
	private int minSal;
	
	@Column(name = "salary_max")
	private int maxSal;
	
	@Column(name = "job_poz")
	private int jobPoz;
	
	@Column(name = "deadline")
	private String deadline;
	
	@Column(name = "is_active")
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;
	

}
