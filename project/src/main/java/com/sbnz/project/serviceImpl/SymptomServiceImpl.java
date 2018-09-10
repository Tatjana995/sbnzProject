package com.sbnz.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.project.model.Symptom;
import com.sbnz.project.repository.SymptomRepository;
import com.sbnz.project.service.SymptomService;

@Service
public class SymptomServiceImpl implements SymptomService{

	@Autowired
	private SymptomRepository symptomRepository;
	
	@Override
	public List<Symptom> getAll(){
		return symptomRepository.findAll();
	}
	
	@Override
	public Symptom findByName(String name){
		return symptomRepository.findByName(name);
	}
	
	@Override
	public List<Symptom> getAllForShow(){
		return symptomRepository.findByResonerFalse();
	}
	
}
