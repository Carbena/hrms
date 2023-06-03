package com.javakamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "education")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "education_id")
	@JsonIgnore
	private int id;
	
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "program_name")
	private String programName;
	
	@Column(name = "start_date")
	private String startDate;
	
	@Column(name = "graduate_date")
	private String graduateDate;
	
	@Column(name = "is_graduated")
	private boolean isGraduated;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "resume_id")
	private Resume resume;
	
}
