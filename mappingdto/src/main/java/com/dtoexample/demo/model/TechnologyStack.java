package com.dtoexample.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="technologies_stack")
public class TechnologyStack {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int techId;
	private String techName;
	public int getTechId() {
		return techId;
	}
	public void setTechId(int techId) {
		this.techId = techId;
	}
	public String getTechName() {
		return techName;
	}
	public void setTechName(String techName) {
		this.techName = techName;
	}
	public TechnologyStack(int techId, String techName) {
		super();
		this.techId = techId;
		this.techName = techName;
	}
	@Override
	public String toString() {
		return "TechnologyStack [techId=" + techId + ", techName=" + techName + "]";
	}
	
	public TechnologyStack() {
		
	}

}
