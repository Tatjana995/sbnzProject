package com.sbnz.project.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.project.model.Medicine;
import com.sbnz.project.repository.MedicineRepository;
import com.sbnz.project.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService{

	@Autowired
	private MedicineRepository medicineRepository;
	
	@Override
	public List<Medicine> getAll(){
		return medicineRepository.findAll();
	}
	
	@Override
	public Medicine findById(Long id){
		return medicineRepository.findById(id);
	}
}
