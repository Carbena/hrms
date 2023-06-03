package com.javakamp.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javakamp.hrms.entities.concretes.EmailValidation;

public interface EmailVerificationRepository extends JpaRepository<EmailValidation,Integer>{

}
