package com.config.server.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class LineItems implements Serializable {
    int productId;
    String productName;
    int quantity;
}
