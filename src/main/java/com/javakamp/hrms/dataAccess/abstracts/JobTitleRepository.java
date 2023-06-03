package com.javakamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javakamp.hrms.entities.concretes.JobTitle;

public interface JobTitleRepository extends JpaRepository<JobTitle,Integer>{

}
