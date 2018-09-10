package com.sbnz.project.DTOs;

import java.util.List;

import com.sbnz.project.model.Patient;
import com.sbnz.project.model.Symptom;

public class FindDiseaseDTO {
	
	private List<Symptom> symptoms;
	private Patient patient;

	public List<Symptom> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<Symptom> symptoms) {
		this.symptoms = symptoms;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	

}
