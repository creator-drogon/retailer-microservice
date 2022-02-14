package com.onlineretailerstore.customer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class CustomerShippingAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int shippingId;
	private String doorNo;
	private String city;
	public CustomerShippingAddress(String doorNo, String city, String layout, String pincode, String streetName) {
		super();
		this.doorNo = doorNo;
		this.city = city;
		this.layout = layout;
		this.pincode = pincode;
		this.streetName = streetName;
	}
	private String layout;
	private String pincode;
	private String streetName;

	public int getShippingId() {
		return shippingId;
	}
	public CustomerShippingAddress() {
		super();
	}
	@Override
	public String toString() {
		return "CustomerShippingAddress [shippingId=" + shippingId + ", doorNo=" + doorNo + ", city=" + city
				+ ", layout=" + layout + ", pincode=" + pincode + ", streetName=" + streetName + "]";
	}
	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
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
