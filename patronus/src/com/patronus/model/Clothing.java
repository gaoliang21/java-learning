package com.patronus.model;

import static com.patronus.constant.Constants.careType;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.patronus.constant.ClothingType;

@Entity
@Table(name = "CLOTHING")
@DiscriminatorValue("CLOTHING")
public class Clothing extends Item{
	
	@Column(name="CLO_SIZE")
	private String size;
	
	@Column(name="CLO_TYPE")
	@Enumerated(EnumType.STRING)
	private ClothingType type;
		
	@Column(name="CARE")
	private careType care;
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public ClothingType getType() {
		return type;
	}
	public void setType(ClothingType type) {
		this.type = type;
	}
	public careType getCare() {
		return care;
	}
	public void setCare(careType care) {
		this.care = care;
	}
}