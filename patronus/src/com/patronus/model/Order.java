package com.patronus.model;
import java.util.*;
import com.patronus.constants.OrderStatus;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	private long orderID;
	
	@Column(name = "DATE_TIME")
	private Date dateTimeProcessed;
	
	@Column(name="STATUS")
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@Column(name="ITEM_LIST")
	private ArrayList<Item> itemsOrdered = new ArrayList<Item>();
	
//	UNSURE about cascade types
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH, 
					  CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name="PATIENT_ID")
	private Client client;
	
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Date getDateTimeProcessed() {
		return dateTimeProcessed;
	}
	public void setDateTimeProcessed(Date dateTimeProcessed) {
		this.dateTimeProcessed = dateTimeProcessed;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public ArrayList<Item> getItemsOrdered() {
		return itemsOrdered;
	}
	public void setItemsOrdered(ArrayList<Item> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}
	
	

}
