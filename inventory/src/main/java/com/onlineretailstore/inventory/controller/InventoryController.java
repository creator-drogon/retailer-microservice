package com.onlineretailstore.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.crossstore.ChangeSetPersister;

import com.onlineretailstore.inventory.entity.Inventory;
import com.onlineretailstore.inventory.service.InventoryService;

import javassist.NotFoundException;

@RestController
@RequestMapping(path = "api/inventory")
public class InventoryController {

	@Autowired
	InventoryService inventoryService;

	@PostMapping(path = "/")
	public ResponseEntity<Inventory> addInventory(@RequestBody Inventory inventory) {

		Inventory _inventory = inventoryService.addInventory(inventory);

		return new ResponseEntity<Inventory>(_inventory, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Inventory> updateInventory(@PathVariable("id") int id, @RequestBody Inventory inventory)
			throws NotFoundException {
		Inventory inventoryData = inventoryService.updateInventory(id, inventory);
		if (inventoryData != null) {

			return new ResponseEntity<Inventory>(inventoryData, HttpStatus.OK);
		} else
			return new ResponseEntity<Inventory>(HttpStatus.NO_CONTENT);

	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<HttpStatus> deleteInventory(@PathVariable("id") int id)
			throws NotFoundException, ChangeSetPersister.NotFoundException {
		Inventory inventoryData = inventoryService.deleteInventory(id);
		if (inventoryData == null) {

			return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
		} else
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_IMPLEMENTED);

	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Inventory> searchInventory(@PathVariable("id") int id) {
		Inventory inventoryData = inventoryService.searchInventory(id);

		if (inventoryData != null) {
			return new ResponseEntity<Inventory>(inventoryData, HttpStatus.OK);
		}

		else
			return new ResponseEntity<Inventory>(HttpStatus.BAD_REQUEST);

	}

}
