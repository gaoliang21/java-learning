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
import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
//import javax.persistence.Transient;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.EnumType;

import com.patronus.constant.ItemOccasion;
import com.patronus.constant.ItemType;



//arrayList --> class, use class with material name variable; then have list of type material in items

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
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="MATERIAL_ID")
	@Column(name="MATERIALS")
	private ArrayList<Material> materials = new ArrayList<Material>();
	

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
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public ItemType getItemType() {
		return itemType;
	}
	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}
	public ItemOccasion getOccasion() {
		return occasion;
	}
	public void setOccasion(ItemOccasion occasion) {
		this.occasion = occasion;
	}
	public ArrayList<Material> getMaterials() {
		return materials;
	}
	public void setMaterials(ArrayList<Material> materials) {
		this.materials = materials;
	}
	
}