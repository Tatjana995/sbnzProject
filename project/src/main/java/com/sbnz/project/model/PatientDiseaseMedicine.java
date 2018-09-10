package com.sbnz.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PatientDiseaseMedicine {
	
	@Id
	@GeneratedValue
	protected Long id;

	@OneToOne(fetch = FetchType.EAGER)
	private Disease disease;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Medicine medicine;
	
	@Column(nullable = false)
	protected Date tdate;

	public PatientDiseaseMedicine() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public Date getDate() {
		return tdate;
	}

	public void setDate(Date date) {
		this.tdate = date;
	}
	
}
