package com.sbnz.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.project.DTOs.FindDiseaseDTO;
import com.sbnz.project.DTOs.SymListDTO;
import com.sbnz.project.model.Disease;
import com.sbnz.project.model.PatientDiseaseMedicine;
import com.sbnz.project.model.Symptom;
import com.sbnz.project.service.DiseaseService;

@RestController
@RequestMapping("/api/disease")
public class DiseaseController {

	
	@Autowired
	private DiseaseService diseaseService;

	
	
	@PostMapping(value="/find/{temp}", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)//patient/{id}   @PathVariable Integer id, 
	public ResponseEntity<PatientDiseaseMedicine> findDisease(@RequestBody FindDiseaseDTO fdDTO, @PathVariable float temp) {
		PatientDiseaseMedicine disease = diseaseService.findDisease(fdDTO, temp);//, patient);
		return new ResponseEntity<PatientDiseaseMedicine>(disease, HttpStatus.OK);

	}

}
