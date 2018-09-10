package com.sbnz.project.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.project.model.PatientChart;
import com.sbnz.project.repository.PatientChartRepository;
import com.sbnz.project.service.PatientChartService;

@Service
public class PatientChartServiceImpl implements PatientChartService{

	@Autowired
	private PatientChartRepository patientChartRepository;
	
	@Override
	public PatientChart findById(Long id){
		return patientChartRepository.findById(id);
	}
}
