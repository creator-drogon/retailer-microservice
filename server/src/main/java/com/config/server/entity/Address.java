package com.config.server.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class Address implements Serializable {

    int addressId;
    String doorNo;
    String streetName;
    String layout;
    String city;
    int pincode;

//    public Address(int id){
//        this.id=id;
//    }
}
