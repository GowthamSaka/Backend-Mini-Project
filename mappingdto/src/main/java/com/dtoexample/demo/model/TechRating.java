package com.dtoexample.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.transaction.Transactional;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Transactional
@NoArgsConstructor
@Data
@Table(name="techrating")
public class TechRating {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int techId;
	
	@Column(name="techname")
	private String techName;
	private int rating;
	
//	@OneToOne
	@ManyToOne
	@JoinColumn(name = "empRegisterId", nullable = false)
	private Employee empRegisterId;
	
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
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public TechRating(int techId, String techName, int rating,Employee empRegisterId) {
		super();
		this.techId = techId;
		this.techName = techName;
		this.rating = rating;
		this.empRegisterId = empRegisterId;
	}
	@Override
	public String toString() {
		return "TechRating [techId=" + techId + ", techName=" + techName + ", rating=" + rating + ", empRegisterId=" + empRegisterId + "]";
	}
	
	public TechRating() {
		
	}
	
}

