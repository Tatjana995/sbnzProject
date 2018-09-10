package com.sbnz.project.service;

import java.util.List;

import com.sbnz.project.model.Patient;

public interface PatientService {
	
	List<Patient> findByName(String name);
	Patient findById(Long id);
	List<Patient> findBySurname(String surname);
	List<Patient> findByNameAndSurname(String name, String surname);
	List<Patient> findAll();
}
