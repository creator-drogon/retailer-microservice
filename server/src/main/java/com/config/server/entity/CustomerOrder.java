package com.config.server.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class CustomerOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int coId;

    int customerId;
    int orderId;
}
