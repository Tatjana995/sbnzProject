package com.sbnz.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbnz.project.model.Disease;
import com.sbnz.project.model.DiseaseSymptoms;

public interface DiseaseSymptomsRepository extends JpaRepository<DiseaseSymptoms, Long>{

	public DiseaseSymptoms findByDisease(Disease disease);
}
