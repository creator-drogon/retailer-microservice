package com.onlineretailstore.inventory.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;

import com.onlineretailstore.inventory.entity.Inventory;
import com.onlineretailstore.inventory.repository.InventoryRepository;

import javassist.NotFoundException;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository inventoryRepo;

	public Inventory addInventory(Inventory inventory) {

		Random random = new Random();
		int low = 5;
		int high = 1000;
		int result = random.nextInt(high - low) + low;
		inventory.setInventoryId(result);
		Inventory _Inventory = inventoryRepo.save(inventory);

		return _Inventory;
	}

	public Inventory updateInventory(int id, Inventory inventory) throws NotFoundException {

		int inventoryId = inventoryRepo.updateInventory(inventory.getQuantity(), id);

		inventory.setInventoryId(inventoryId);
		return inventory;

//		Optional<Inventory> inventoryData = inventoryRepo.findById(id);
//		Inventory updated = inventoryData.get();
//
//		if (inventoryData.isPresent()) {
//
////			updated.setInventoryId(id);
//			updated.setProductId(inventory.getProductId());
//			updated.setQuantity(inventory.getQuantity());
//
//			return inventoryRepo.save(updated);
//		}
//
//		else
//			throw new NotFoundException("No such inventory exists");
	}

	public Inventory deleteInventory(int id)
			throws org.springframework.data.crossstore.ChangeSetPersister.NotFoundException {
		Optional<Inventory> inventoryData = inventoryRepo.findById(id);

		if (inventoryData.isPresent()) {
			inventoryRepo.deleteById(id);
		}

		else
			throw new ChangeSetPersister.NotFoundException();
		return null;
	}

	public Inventory searchInventory(int id) {
		Inventory inventory = new Inventory();
		Optional<Inventory> inventoryData = inventoryRepo.findById(id);
		if (inventoryData.isPresent()) {
			inventory = inventoryData.get();
			return inventory;
		} else
			return null;
	}

}
