package com.config.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory implements Serializable {

    private int inventoryId;

    private int productId;

    private int quantity;
}
