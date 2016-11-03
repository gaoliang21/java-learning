package com.patronus.model;

import com.patronus.constants.AccessoryType;

import javax.persistence.Column;
//QUESTION : need import all used annotations even if already imported in item (extended class)?
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;



@Entity
@Table(name = "ACCESSORIES")
@DiscriminatorValue("ACCESSORY")
public class Accessory extends Item{

	@Column(name="ACC_TYPE")
	@Enumerated(EnumType.STRING)
	private AccessoryType type;
	
	public AccessoryType getType() {
		return type;
	}
	public void setType(AccessoryType type) {
		this.type = type;
	}
	
}
