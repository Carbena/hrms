package com.javakamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javakamp.hrms.entities.concretes.Resume;

@Repository
public interface ResumeRepository extends JpaRepository<Resume,Integer> {

	Resume findByCandidate_Id(int candidateId);
	
}
