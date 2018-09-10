package com.sbnz.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbnz.project.model.PatientChart;

public interface PatientChartRepository extends JpaRepository<PatientChart, Long>{

	PatientChart findById(Long id);
}
