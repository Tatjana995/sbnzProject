package com.sbnz.project.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class PatientChart {
	
	@Id
	@GeneratedValue
	protected Long id;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private Set<PatientDiseaseMedicine> history;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private Set<Alergie> alergies;

	public PatientChart() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<PatientDiseaseMedicine> getHistory() {
		return history;
	}

	public void setHistory(Set<PatientDiseaseMedicine> history) {
		this.history = history;
	}

	public Set<Alergie> getAlergies() {
		return alergies;
	}

	public void setAlergies(Set<Alergie> alergies) {
		this.alergies = alergies;
	}

}
