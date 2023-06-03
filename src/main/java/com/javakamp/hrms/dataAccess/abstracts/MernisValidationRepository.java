package com.javakamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javakamp.hrms.entities.concretes.MernisValidation;

@Repository
public interface MernisValidationRepository extends JpaRepository<MernisValidation,Integer>{

}
