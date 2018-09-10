package com.sbnz.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.project.model.Medicine;
import com.sbnz.project.service.MedicineService;


@RestController
@RequestMapping("/api/medicine")
public class MedicineController {
	
	@Autowired
	private MedicineService medicineService;
	
	@GetMapping(value="/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Medicine>> getAll(HttpServletRequest request){
		List<Medicine> s = medicineService.getAll();
		System.out.println("PROVERAAAAAA: "+s.get(0).getGroup_med());
		System.out.println(s.size());
		return new ResponseEntity<List<Medicine>>(s, HttpStatus.OK);
	}

}
