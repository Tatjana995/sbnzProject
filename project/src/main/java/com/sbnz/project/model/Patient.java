package com.sbnz.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue
	protected Long id;
	
	@Column(nullable = false)
	protected String name;
	
	@Column(nullable = false)
	protected String surname;
	
	@OneToOne(fetch = FetchType.EAGER)
	private User doctor;
	
	@OneToOne(fetch = FetchType.EAGER)
	private PatientChart patientChart;

	public Patient() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public User getDoctor() {
		return doctor;
	}

	public void setDoctor(User doctor) {
		this.doctor = doctor;
	}

	public PatientChart getPatientChart() {
		return patientChart;
	}

	public void setPatientChart(PatientChart patientChart) {
		this.patientChart = patientChart;
	}

}
