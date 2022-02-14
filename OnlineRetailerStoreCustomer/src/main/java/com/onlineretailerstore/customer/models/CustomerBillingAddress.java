package com.onlineretailerstore.customer.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class CustomerBillingAddress implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private int billingId;
	public CustomerBillingAddress(String doorNo, String city, String layout, String pincode,
			String streetName) {
		super();
		this.billingId = billingId;
		this.doorNo = doorNo;
		this.city = city;
		this.layout = layout;
		this.pincode = pincode;
		this.streetName = streetName;
	}
	private String doorNo;
	private String city;
	private String layout;
	private String pincode;
	private String streetName;
	
	public CustomerBillingAddress() {
		super();
	}

	public int getBillingId() {
		return billingId;
	}
	@Override
	public String toString() {
		return "CustomerBillingAddress [billingId=" + billingId + ", doorNo=" + doorNo + ", city=" + city + ", layout="
				+ layout + ", pincode=" + pincode + ", streetName=" + streetName + "]";
	}
	public void setBillingId(int billingId) {
		this.billingId = billingId;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLayout() {
		return layout;
	}
	public void setLayout(String layout) {
		this.layout = layout;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	
	
}
