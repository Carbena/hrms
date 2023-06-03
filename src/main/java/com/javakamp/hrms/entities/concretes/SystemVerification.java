package com.javakamp.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper=true)
@Table(name = "system_validation")
@PrimaryKeyJoinColumn(name = "validation_id")
public class SystemVerification extends Validation {

	@Column(name= "is_verified")
	private boolean isVerified;
	
	@OneToOne
	@JoinColumn(name = "validation_user_id")
	private Employer employer;
	
	@OneToOne
	@JoinColumn(name = "valid_system_user_id")
	private SystemUser systemUser;
	
}
