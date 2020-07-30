package com.rubix.expense_tracker.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity

@Table(name = "expense_currency")

public class ExpenseCurrency {
	public ExpenseCurrency() {

	}

	public ExpenseCurrency(long id, String currency, String code) {
		super();
		this.id = id;
		this.currency = currency;
		this.code = code;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;

	@Column(name = "currency", nullable = false)
	private String currency;
	@Column(name = "code", nullable = false)
	private String code;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	// @ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne(optional = false)
	@JoinColumn(name = "expense_detail_id", referencedColumnName = "id")

	private Employee employee;
	// @JsonBackReference

	/*
	 * public Employee getEmployee() { return employee; } public void
	 * setEmployee(Employee employee) { this.employee = employee; }
	 */

	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "ExpenseCurrency [id=" + id + ", currency=" + currency + ", code=" + code + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the userIden
	 */

}
