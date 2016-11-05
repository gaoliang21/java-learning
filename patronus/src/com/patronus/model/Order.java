package com.patronus.model;
import java.util.*;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.patronus.constant.OrderStatus;

@Entity
@Table(name = "ORDER")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	private long orderID;
	
	@Column(name = "DATE_TIME")
	private Date processedDateTime;
	
	@Column(name="STATUS")
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	
	@OneToMany(fetch = FetchType.EAGER)
	@Column(name="ITEM_LIST")
	private ArrayList<Item> items = new ArrayList<Item>();
	
//	UNSURE about cascade types
	@OneToOne(fetch = FetchType.EAGER)
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
	public Date getProcessedDateTime() {
		return processedDateTime;
	}
	public void setProcessedDateTime(Date processedDateTime) {
		this.processedDateTime = processedDateTime;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public ArrayList<Item> getIitems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	

}