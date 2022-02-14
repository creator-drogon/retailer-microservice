package com.onlineretailstore.inventory.service;

import com.onlineretailstore.inventory.entity.Inventory;
import org.springframework.data.crossstore.ChangeSetPersister;

import javassist.NotFoundException;

public interface InventoryService {

	Inventory addInventory(Inventory inventory);

	Inventory updateInventory(int id, Inventory inventory) throws NotFoundException;

	Inventory deleteInventory(int id) throws ChangeSetPersister.NotFoundException;

	Inventory searchInventory(int id);
}
