package com.sbnz.project.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class Medicine {
	
	@Id
	@GeneratedValue
	protected Long id;
	
	@Column(nullable = false, unique = true)
	protected String name;
	
	@Column(nullable = false)
	protected String group_med;
	
	@OneToMany(fetch = FetchType.EAGER)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private Set<Component> components;

	public Medicine() {
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

	public Set<Component> getComponents() {
		return components;
	}

	public void setComponents(Set<Component> components) {
		this.components = components;
	}

	public String getGroup_med() {
		return group_med;
	}

	public void setGroup_med(String group_med) {
		this.group_med = group_med;
	}
	
	

}
