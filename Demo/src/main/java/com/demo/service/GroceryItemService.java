package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.GroceryItem;
import com.demo.repository.GroceryItemRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class GroceryItemService{

	private GroceryItemRepo giRepo;
	
	public GroceryItem getGroceryItemById(int id) {
		GroceryItem gItem = giRepo.findById(id);
		if(gItem == null) {
			throw new NullPointerException();
		}
		return gItem;
	}
	
	public List<GroceryItem> getAllItems(){
		List<GroceryItem> items = giRepo.findAll();
		if(items.size() == 0) {
			throw new NullPointerException();
		}
		return items;
	}

	public void saveItem(String itemName, int cost, String itemType, int quantity) {
		GroceryItem item = new GroceryItem();
		item.setItemName(itemName);
		item.setCost(cost);
		item.setItemType(itemType);
		item.setQuantity(quantity);
		giRepo.save(item);
	}
	
	public void removeItem(GroceryItem item) {
		giRepo.delete(item);
	}
}
