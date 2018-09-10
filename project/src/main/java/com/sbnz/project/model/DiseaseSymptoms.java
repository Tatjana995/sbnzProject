package com.sbnz.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class DiseaseSymptoms {
	
	@Id
	@GeneratedValue
	protected Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	protected Disease disease;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	protected Set<Symptom> symptoms = new HashSet<>();

	public DiseaseSymptoms() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	public Set<Symptom> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(Set<Symptom> symptoms) {
		this.symptoms = symptoms;
	}
	
	

}
