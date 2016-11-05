package com.patronus.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.patronus.constant.ShoeType;;

@Entity
@Table(name = "SHOES")
@DiscriminatorValue("SHOES")
public class Shoes extends Item {
	
	@Column(name="SH_SIZE")
	private int size;
	
	@Column(name="HEEL_SIZE")
	private int heelSizeInches;
	
	@Column(name="SH_TYPE")
	private ShoeType type;
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public ShoeType getType() {
		return type;
	}
	public void setType(ShoeType type) {
		this.type = type;
	}

	public int getHeelSizeInches() {
		return heelSizeInches;
	}
	public void setHeelSizeInches(int heelSizeInches) {
		this.heelSizeInches = heelSizeInches;
	}
}
