package com.rs.fer.loan.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class LoanAccount {
	
	@Id
	@Column(name = "loanaccount_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanAccountId;

	@Column
	private String created;

	@Column
	private String updated;

	@Column
	private String status;

	public LoanAccount() {

	}

	public LoanAccount(String status) {

		this.status = status;
	}

	@OneToMany(targetEntity = Applicant.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "loan_acc_id", referencedColumnName = "loanaccount_id")
	private Set<Applicant> applicants;
}
