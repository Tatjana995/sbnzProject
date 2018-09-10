package com.sbnz.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sbnz.project.model.Symptom;

public interface SymptomRepository extends JpaRepository<Symptom, Long>{

	Symptom findByName(String name);
	
	List<Symptom> findByResonerFalse();

}
