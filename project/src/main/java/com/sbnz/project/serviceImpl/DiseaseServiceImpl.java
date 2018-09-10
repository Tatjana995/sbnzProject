package com.sbnz.project.serviceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
//import java.util.logging.Logger;
import java.util.Set;

//import org.apache.log4j.spi.LoggerFactory;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.project.DTOs.FindDiseaseDTO;
import com.sbnz.project.model.Disease;
import com.sbnz.project.model.DiseaseSymptoms;
import com.sbnz.project.model.Patient;
import com.sbnz.project.model.PatientChart;
import com.sbnz.project.model.PatientDiseaseMedicine;
import com.sbnz.project.model.Symptom;
import com.sbnz.project.repository.DiseaseRepository;
import com.sbnz.project.repository.DiseaseSymptomsRepository;
import com.sbnz.project.repository.PatientChartRepository;
import com.sbnz.project.repository.SymptomRepository;
import com.sbnz.project.service.DiseaseService;
import com.sbnz.project.service.SymptomService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DiseaseServiceImpl implements DiseaseService{
	
	public Logger loggerD = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DiseaseRepository diseaseRepository;
	
	@Autowired
	private DiseaseSymptomsRepository diseaseSymptomsRepository;
	
	@Autowired
	private SymptomRepository symptomRepository;
	
	@Autowired
	private PatientChartRepository patientChartRepository;
	
	@Autowired
	private KieContainer kieContainer;

	@Override
	public PatientDiseaseMedicine findDisease(FindDiseaseDTO fdDTO, float temp) {
		KieSession ksession = kieContainer.newKieSession("DroolsKS");

		List<Disease> diseases = diseaseRepository.findAll();
		System.out.println(diseases.size());
		System.out.println("Simptomi iz fronta: "+fdDTO.getSymptoms().size());
		
		Date today = new Date();
		Calendar calendar = new GregorianCalendar();
		
		
		calendar.setTime(today);
		calendar.add(Calendar.DAY_OF_MONTH, -60);
		Date last60days = calendar.getTime();
		ksession.setGlobal("last60days", last60days);
		
		calendar.setTime(today);
		calendar.add(Calendar.MONTH, -6);
		Date last6months = calendar.getTime();
		ksession.setGlobal("last6months", last6months);
		
		calendar.setTime(today);
		calendar.add(Calendar.DAY_OF_MONTH, -14);
		Date last14days = calendar.getTime();
		ksession.setGlobal("last14days", last14days);
		
		calendar.setTime(today);
		calendar.add(Calendar.DAY_OF_MONTH, -21);
		Date last21days = calendar.getTime();
		ksession.setGlobal("last21days", last21days);
		
		Patient patient = fdDTO.getPatient();
		PatientChart patChart = patientChartRepository.findById(patient.getPatientChart().getId());
		
		System.out.println("Chart: "+patChart.getId());
		System.out.println("History: "+patChart.getHistory().size());
		
		ksession.setGlobal("temp", temp);
		
		ksession.getAgenda().getAgendaGroup("diseases").setFocus();
		addFactInMemory(ksession, fdDTO.getSymptoms(), diseases, patChart.getHistory());	    

	    //ksession.dispose(); // Stateful rule session must always be disposed when finished
		int firedRules = ksession.fireAllRules();
		System.out.println("opaljena pravila: "+firedRules);

		PatientDiseaseMedicine pdm = new PatientDiseaseMedicine();
		ksession.insert(pdm);
		
		ksession.getAgenda().getAgendaGroup("diagnose disease").setFocus();
		firedRules = ksession.fireAllRules();
		System.out.println("opaljena pravila opet: "+firedRules);

		ksession.dispose();

		for (Disease disease : diseases) {
			System.out.println(disease.getName());
			System.out.println(disease.getMatchedNumSym());
			System.out.println(disease.isSpecificChecked());
		}

		if(pdm.getDisease() != null){
			return pdm;
		}
		return null;
	}

	private void addFactInMemory(KieSession kieSession, List<Symptom> symptoms,List<Disease> diseases, Set<PatientDiseaseMedicine> pdms) {// Patient patient,

		for (Symptom symptom : symptoms) {
			kieSession.insert(symptom);
		}
		
		for(PatientDiseaseMedicine pdm: pdms){
			kieSession.insert(pdm);
		}

		for (Disease disease : diseases) {
			disease.setMatchedNumSym(0L);
			disease.setSpecificChecked(false);
			DiseaseSymptoms ds = diseaseSymptomsRepository.findByDisease(disease);
			System.out.println(ds.getId());
			Collection<Symptom> syms = ds.getSymptoms();
			for(Symptom s : syms){
				disease.getSymptoms().add(s.getName());
			}
			if (!disease.getSymptoms().isEmpty()) {
				kieSession.insert(disease);
			}
		}

	}
	
}
