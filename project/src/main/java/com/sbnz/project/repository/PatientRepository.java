package com.sbnz.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbnz.project.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{

	public Patient findById(Long id);
	
	public List<Patient> findByNameContaining(String name);
	
	public List<Patient> findBySurnameContaining(String surname);
	
	public List<Patient> findByNameContainingAndSurnameContaining(String name, String surname);
}
