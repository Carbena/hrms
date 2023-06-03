package com.javakamp.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javakamp.hrms.entities.concretes.JobAdv;

@Repository
public interface JobAdvRepository extends JpaRepository<JobAdv,Integer>{

	List<JobAdv> getByEmployer_id(int employer);
}
