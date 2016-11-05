package com.patronus.model;
import java.util.*;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.patronus.constant.ItemOccasion;
import com.patronus.constant.ItemType;

//import javax.persistence.Transient;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;



@Entity
@Table(name = "Items")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name = "ITEM_TYPE", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("ITEM")
public class Item{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ITEM_ID")
	private long itemID;
	
	@Column(name="NUM_IN_STOCK")
	private int numInStock;
	
	@Column(name="PRICE")
	private double price;
	
	@Column(name="MADE_IN")
	private String madeIn;
	
	@Column(name="COLOR")
	private String color;
	
	@Column(name="ITEM_NAME")
	private String itemName;
	
	@Column(name="ITEM_TYPE")
	@Enumerated(EnumType.STRING)
	private ItemType itemType;
	
	@Column(name="OCCASION")
	@Enumerated(EnumType.STRING)
	private ItemOccasion occasion;
	
	@Column(name="MATERIALS")
	private ArrayList<String> materials = new ArrayList<String>();
	
	@Column(name="FEATURES")
	private ArrayList<String> specialFeats = new ArrayList<String>();
	
	@Column(name="OCCASION")
	private ArrayList<String> tags = new ArrayList<String>();

	public long getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public int getNumInStock() {
		return numInStock;
	}
	public void setNumInStock(int numInStock) {
		this.numInStock = numInStock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getMadeIn() {
		return madeIn;
	}
	public void setMadeIn(String madeIn) {
		this.madeIn = madeIn;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getName() {
		return itemName;
	}
	public void setName(String itemName) {
		this.itemName = itemName;
	}
	public ItemType getItemType() {
		return itemType;
	}
	public ItemOccasion getOccasion() {
		return occasion;
	}
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	public void setOccasion(ItemOccasion occasion) {
		this.occasion = occasion;
	}
	public ArrayList<String> getMaterials() {
		return materials;
	}
	public void setMaterials(ArrayList<String> materials) {
		this.materials = materials;
	}
	public ArrayList<String> getSpecialFeats() {
		return specialFeats;
	}
	public void setSepcialFeats(ArrayList<String> sepcialFeats) {
		this.specialFeats = sepcialFeats;
	}
	public ArrayList<String> getTags() {
		return tags;
	}
	public void setTags(ArrayList<String> tags) {
		this.tags = tags;
	}
	
	
	
}