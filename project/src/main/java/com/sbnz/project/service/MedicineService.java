package com.sbnz.project.service;

import java.util.List;

import com.sbnz.project.model.Medicine;

public interface MedicineService {

	List<Medicine> getAll();
	Medicine findById(Long id);
}
