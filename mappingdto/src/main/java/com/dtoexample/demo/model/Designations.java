package com.dtoexample.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="desginations")
public class Designations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int designationId;
	private String designationName;
	public int getDesignationId() {
		return designationId;
	}
	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}
	public String getDesignationName() {
		return designationName;
	}
	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}
	public Designations(int designationId, String designationName) {
		super();
		this.designationId = designationId;
		this.designationName = designationName;
	}
	@Override
	public String toString() {
		return "Designations [designationId=" + designationId + ", designationName=" + designationName + "]";
	}
	
	public Designations() {
		
	}

}
