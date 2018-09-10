package com.sbnz.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

@Entity
public class Disease {

	@Id
	@GeneratedValue
	protected Long id;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	protected DiseaseGroup group_num;
	
	@Column(nullable = false, unique = true)
	protected String name;
	
	//@ManyToMany(fetch = FetchType.EAGER)
	//@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	@Transient
	private Set<String> symptoms = new HashSet<>();
	
	@Column
	protected Long matched_num_sym;
	
	@Column(nullable = false)
	protected boolean specific_checked;

	public Disease() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DiseaseGroup getGroup() {
		return group_num;
	}

	public void setGroup(DiseaseGroup group) {
		this.group_num = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(Set<String> symptoms) {
		this.symptoms = symptoms;
	}

	public Long getMatchedNumSym() {
		return matched_num_sym;
	}

	public void setMatchedNumSym(Long matchedNumSym) {
		this.matched_num_sym = matchedNumSym;
	}

	public boolean isSpecificChecked() {
		return specific_checked;
	}

	public void setSpecificChecked(boolean specificChecked) {
		this.specific_checked = specificChecked;
	}
	
}
