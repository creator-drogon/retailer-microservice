package com.config.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Embedded;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Validated
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

    int customerId;
    String customerName;

    @Email
    String customerEmail;

    @Embedded
    Set<Address> customerBillingAddress;

    @Embedded
    Set<Address> customerShippingAddress;
}
