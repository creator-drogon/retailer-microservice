package com.onlineretailerstore.customer.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
@Entity
public class Customer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String customerName;
	@Email
    private String customerEmail;
    @OneToMany(cascade = CascadeType.ALL)
	private Set<Address> customerShippingAddress;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Address> customerBillingAddress;

//	public int getCustomerId() {
//		return customerId;
//	}
//	public Customer() {
//		super();
//	}
//	/*public Customer(String name, String email, Set<CustomerShippingAddress> customerShippingAddress,
//			Set<CustomerBillingAddress> customerBillingAddress) {
//		super();
//		this.customerName = name;
//		this.customerEmail = email;
//		this.customerShippingAddress = customerShippingAddress;
//		this.customerBillingAddress = customerBillingAddress;
//	}*/
//	public void setCustomerId(int customerId) {
//		this.customerId = customerId;
//	}
//
//	/*public Customer(int customerId, String name, String email, Set<CustomerShippingAddress> customerShippingAddress,
//					Set<CustomerBillingAddress> customerBillingAddress) {
//		super();
//		this.customerId = customerId;
//		this.customerName = name;
//		this.customerEmail = email;
//		this.customerBillingAddress = customerBillingAddress;
//		this.customerShippingAddress = customerShippingAddress;
//	}*/
//	public String getCustomerName() {
//		return customerName;
//	}
//	public void setCustomerName(String customerName) {
//		this.customerName = customerName;
//	}
//	public String getCustomerEmail() {
//		return customerEmail;
//	}
//	public void setCustomerEmail(String customerEmail) {
//		this.customerEmail = customerEmail;
//	}
//	public Set<CustomerBillingAddress> getCustomerBillingAddress() {
//		return customerBillingAddress;
//	}
//	public void setCustomerBillingAddress(Set<CustomerBillingAddress> customerBillingAddress) {
//		this.customerBillingAddress = customerBillingAddress;
//	}
//	public Set<CustomerShippingAddress> getCustomerShippingAddress() {
//		return customerShippingAddress;
//	}
//	public void setCustomerShippingAddress(Set<CustomerShippingAddress> customerShippingAddress) {
//		this.customerShippingAddress = customerShippingAddress;
//	}
//	 public void addAddress(CustomerBillingAddress customerBillingAddress) {
//	        this.customerBillingAddress.add(customerBillingAddress);
//}
//	 public void addAddress(CustomerShippingAddress customerShippingAddress) {
//	        this.customerShippingAddress.add(customerShippingAddress);
//}
	
}
