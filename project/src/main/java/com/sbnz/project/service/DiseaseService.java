package com.sbnz.project.service;

import java.util.List;

import org.kie.api.KieBase;
import org.kie.api.KieBaseConfiguration;
import org.kie.api.KieServices;
import org.kie.api.conf.EventProcessingOption;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sbnz.project.DTOs.FindDiseaseDTO;
import com.sbnz.project.model.Disease;
import com.sbnz.project.model.PatientDiseaseMedicine;
import com.sbnz.project.model.Symptom;
import com.sbnz.project.repository.DiseaseRepository;

public interface DiseaseService {

	PatientDiseaseMedicine findDisease(FindDiseaseDTO fdDTO, float temp);	
	
}
