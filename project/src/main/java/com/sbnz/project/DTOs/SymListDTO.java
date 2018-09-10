package com.sbnz.project.DTOs;

import java.util.List;

import com.sbnz.project.model.Symptom;

public class SymListDTO {
	
	private List<Symptom> symptoms;
	
	

	public SymListDTO() {
		super();
	}

	public List<Symptom> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<Symptom> symptoms) {
		this.symptoms = symptoms;
	}
	
	

}
