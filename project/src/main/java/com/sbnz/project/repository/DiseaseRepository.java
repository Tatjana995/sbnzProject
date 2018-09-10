package com.sbnz.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbnz.project.model.Disease;

public interface DiseaseRepository extends JpaRepository<Disease, Long>  {

	public Disease findByName(String name);
	
}
