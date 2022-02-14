package com.config.server.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Cart implements Serializable {
    int cartId;
    int customerId;
    int orderId;
    List<LineItems> lineItems;
}
