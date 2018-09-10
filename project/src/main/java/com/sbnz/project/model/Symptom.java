package com.sbnz.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Symptom {

	@Id
	@GeneratedValue
	protected Long id;
	
	@Column(nullable = false)
	protected String name;
	
	@Column
	protected boolean specific_mark;
	
	@Column
	protected boolean resoner;

	public Symptom() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSpecific() {
		return specific_mark;
	}

	public void setSpecific(boolean specific) {
		this.specific_mark = specific;
	}

	public boolean isResoner() {
		return resoner;
	}

	public void setResoner(boolean resoner) {
		this.resoner = resoner;
	}
	
	
}
