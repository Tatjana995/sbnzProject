package com.sbnz.project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.sbnz.project.model.Disease;
import com.sbnz.project.model.DiseaseSymptoms;
import com.sbnz.project.repository.DiseaseSymptomsRepository;
import com.sbnz.project.service.DiseaseSymptomsService;

public class DiseaseSymptomsServiceImpl implements DiseaseSymptomsService{

	@Autowired
	private DiseaseSymptomsRepository diseaseSymptomsRepository;
	
	@Override
	public DiseaseSymptoms findByDisease(Disease disease){
		return diseaseSymptomsRepository.findByDisease(disease);
	}
}
