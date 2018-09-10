package com.sbnz.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.project.model.Patient;
import com.sbnz.project.repository.PatientRepository;
import com.sbnz.project.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public Patient findById(Long id){
		return patientRepository.findById(id);
	}
	
	@Override
	public List<Patient> findByName(String name){
		return patientRepository.findByNameContaining(name);
	}
	
	@Override
	public List<Patient> findBySurname(String surname){
		return patientRepository.findBySurnameContaining(surname);
	}
	
	@Override
	public List<Patient> findByNameAndSurname(String name, String surname){
		return patientRepository.findByNameContainingAndSurnameContaining(name, surname);
	}
	
	@Override
	public List<Patient> findAll(){
		return patientRepository.findAll();
	}
}
