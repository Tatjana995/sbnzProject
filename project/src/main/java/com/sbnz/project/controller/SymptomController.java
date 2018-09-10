package com.sbnz.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.project.model.Symptom;
import com.sbnz.project.security.JwtTokenUtil;
import com.sbnz.project.service.SymptomService;

@RestController
@RequestMapping(value = "/api/symptom")
@CrossOrigin
public class SymptomController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private SymptomService symptomService;
	
	@GetMapping(value="/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Symptom>> getAll(HttpServletRequest request){
		List<Symptom> s = symptomService.getAllForShow();
		System.out.println(s.size());
		return new ResponseEntity<List<Symptom>>(s, HttpStatus.OK);
	}
}
