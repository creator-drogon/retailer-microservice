package com.config.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    int productId;
    String productName;
    String productDescription;
    String productPrice;
    int quantity;

}
