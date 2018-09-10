package com.sbnz.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbnz.project.model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long>{

	Medicine findById(Long id);
}
