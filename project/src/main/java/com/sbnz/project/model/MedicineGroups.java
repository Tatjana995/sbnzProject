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

//@Entity
public class MedicineGroups {
	
	@Id
	@GeneratedValue
	protected Long id;
	
	@Column(nullable = false, unique = true)
	@Enumerated(EnumType.STRING)
	protected MedicineGroup group_med;
	
	@OneToMany(fetch = FetchType.EAGER)
	@Cascade({ org.hibernate.annotations.CascadeType.ALL })
	private Set<Medicine> medicines;

	public MedicineGroups() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MedicineGroup getGroup() {
		return group_med;
	}

	public void setGroup(MedicineGroup group) {
		this.group_med = group;
	}

	public Set<Medicine> getMedicines() {
		return medicines;
	}

	public void setMedicines(Set<Medicine> medicines) {
		this.medicines = medicines;
	}
	
	

}
