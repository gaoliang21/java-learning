package com.patronus.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "CLIENTS")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLIENT_ID")
	private long clientID;
	
	@Column(name="CLI_NAME")
	private String clientName;
	
	@Column(name="SHIPPING_ADR")
	private String shippingAdr;
	
	@Column(name="BILLING_ADR")
	private String billingAdr;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name="PATIENT_ID")
	private Order order;
	
	public long getClientID() {
		return clientID;
	}
	public void setClientID(long clientID) {
		this.clientID = clientID;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getShippingAdr() {
		return shippingAdr;
	}
	public void setShippingAdr(String shippingAdr) {
		this.shippingAdr = shippingAdr;
	}
	public String getBillingAdr() {
		return billingAdr;
	}
	public void setBillingAdr(String billingAdr) {
		this.billingAdr = billingAdr;
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
