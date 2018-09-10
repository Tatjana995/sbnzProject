package com.sbnz.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.project.DTOs.PatientSearchDTO;
import com.sbnz.project.model.Patient;
import com.sbnz.project.model.User;
import com.sbnz.project.security.JwtTokenUtil;
import com.sbnz.project.service.PatientService;
import com.sbnz.project.service.UserService;

@RestController
@RequestMapping(value = "/api/patient")
@CrossOrigin
public class PatientController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private UserService userService;
	
	@Value("${jwt.header}")
	private String tokenHeader;
	
	@GetMapping(value="/getById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Patient> findPatientById(HttpServletRequest request, @PathVariable Long id){
		String token = request.getHeader(tokenHeader);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		User doctor = userService.findByUsername(username);
		
		Patient p = patientService.findById(id);
		Patient response = null;
		if(p.getDoctor().getId().equals(doctor.getId())){
			response = p;
		}
		return new ResponseEntity<Patient>(p,HttpStatus.OK);
	}
	
	@GetMapping(value="/getByName/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Patient>> findPatientByName(HttpServletRequest request, @PathVariable String name){
		String token = request.getHeader(tokenHeader);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		User doctor = userService.findByUsername(username);
		
		List<Patient> p = patientService.findByName(name);
		List<Patient> response = new ArrayList<Patient>();
		for(Patient pat: p){
			if(pat.getDoctor().getId().equals(doctor.getId())){
				response.add(pat);
			}
		}
		return new ResponseEntity<List<Patient>>(response,HttpStatus.OK);
	}
	
	@GetMapping(value="/getBySurname/{surname}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Patient>> findPatientBySurname(HttpServletRequest request,@PathVariable String surname){
		String token = request.getHeader(tokenHeader);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		User doctor = userService.findByUsername(username);
		
		List<Patient> p = patientService.findBySurname(surname);
		List<Patient> response = new ArrayList<Patient>();
		
		for(Patient pat: p){
			if(pat.getDoctor().getId().equals(doctor.getId())){
				response.add(pat);
			}
		}
		return new ResponseEntity<List<Patient>>(response,HttpStatus.OK);
	}
	
	@PostMapping(value="/getByNameAndSurname", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Patient>> findPatientByNameAndSurname(HttpServletRequest request,@RequestBody PatientSearchDTO psDto){
		String token = request.getHeader(tokenHeader);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		User doctor = userService.findByUsername(username);
		
		List<Patient> p = patientService.findByNameAndSurname(psDto.getName(), psDto.getSurname());
		List<Patient> response = new ArrayList<Patient>();
		
		for(Patient pat: p){
			if(pat.getDoctor().getId().equals(doctor.getId())){
				response.add(pat);
			}
		}
		return new ResponseEntity<List<Patient>>(response, HttpStatus.OK);
	}
	
	@GetMapping(value="/getAll", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Patient>> findAll(HttpServletRequest request){
		String token = request.getHeader(tokenHeader);
		String username = jwtTokenUtil.getUsernameFromToken(token);
		User doctor = userService.findByUsername(username);
		
		List<Patient> p = patientService.findAll();
		List<Patient> response = new ArrayList<Patient>();
		
		for(Patient pat: p){
			if(pat.getDoctor().getId().equals(doctor.getId())){
				response.add(pat);
			}
		}
		return new ResponseEntity<List<Patient>>(response,HttpStatus.OK);
	}
}
