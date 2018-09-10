package com.sbnz.project.service;

import java.util.List;

import com.sbnz.project.model.Symptom;

public interface SymptomService {

	List<Symptom> getAll();
	Symptom findByName(String name);
	
	List<Symptom> getAllForShow();
}
