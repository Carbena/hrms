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
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "mernis_validation")
@PrimaryKeyJoinColumn(name = "validation_id")
public class MernisValidation extends Validation{

	@Column(name = "is_verified")
	private boolean isVerified;
	
	@OneToOne
	@JoinColumn(name = "validation_user_id")
	private Candidate candidate;
}





