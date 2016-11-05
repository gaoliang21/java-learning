package com.patronus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Materials")
public class Material {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long materialID;
	
	@Column(name = "MATERIAL_NAME")
	private String materialName;
	
	public long getMaterialID() {
		return materialID;
	}

	public void setMaterialID(long materialID) {
		this.materialID = materialID;
	}
	
	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
}
