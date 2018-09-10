package com.sbnz.project.service;

import com.sbnz.project.model.Disease;
import com.sbnz.project.model.DiseaseSymptoms;

public interface DiseaseSymptomsService {

	DiseaseSymptoms findByDisease(Disease disease);
}
