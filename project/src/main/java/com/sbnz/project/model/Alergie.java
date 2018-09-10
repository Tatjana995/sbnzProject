package com.sbnz.project.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Alergie {
	
	@Id
	@GeneratedValue
	protected Long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Component component;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Medicine medicine;

	public Alergie() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Component getComponent() {
		return component;
	}

	public void setComponent(Component component) {
		this.component = component;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	
}
