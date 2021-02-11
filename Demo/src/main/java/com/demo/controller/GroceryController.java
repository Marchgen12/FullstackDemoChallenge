package com.demo.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.GroceryItem;
import com.demo.model.GroceryList;
import com.demo.service.GroceryItemService;
import com.demo.service.GroceryListService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@NoArgsConstructor
@AllArgsConstructor(onConstructor=@__(@Autowired))
@CrossOrigin("*")
@RequestMapping("/grocery-lists")
public class GroceryController {

	private GroceryItemService giServ;
	private GroceryListService glServ;
	
	
	//////This are the first 3 Implementation with regarding to the List
	@GetMapping()
	public ResponseEntity<List<GroceryList>> getAllList(){
		List<GroceryList> lists = glServ.getAllList();
		if(lists.size() == 0) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(lists, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<String> createList(@RequestBody LinkedHashMap<String, String> listMap){
		String listName = listMap.get("listName");
		if(listName != null) {
			glServ.saveList(listName);
			return new ResponseEntity<>("List created", HttpStatus.ACCEPTED);
		}		
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{listId}")
	public ResponseEntity<String> removeListById(@PathVariable("listId") int listId){
		GroceryList list = glServ.getGroceryListById(listId);
		if(list != null) {
			glServ.deleteList(list);
			return new ResponseEntity<>("Item removed from the list", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>("Item not in the list", HttpStatus.NOT_FOUND);
	}
	
	///these are for the second part of the implementation
	@GetMapping("/items/{itemid}")
	public ResponseEntity<GroceryItem> getItemById(@PathVariable("itemId") int itemId){
		GroceryItem item = giServ.getGroceryItemById(itemId);
		if(item == null) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(item, HttpStatus.OK);
	}
	
	@GetMapping("/items")
	public ResponseEntity<List<GroceryItem>> getAllItems(){
		List<GroceryItem> items = giServ.getAllItems();
		if(items.size() == 0) {
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(items, HttpStatus.OK);
	}
	
//	@PostMapping("/items/{itemId}/{listId}")
//	public ResponseEntity<String> itemsToList(@PathVariable("itemId") int itemId, @PathVariable("listId") int listId){
//		GroceryItem item = giServ.getGroceryItemById(itemId);
//		if(item != null) {
//			
//			return new ResponseEntity<>("Item added to list", HttpStatus.ACCEPTED);
//		}
//		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
//	}
	
	@PostMapping("/items")
	public ResponseEntity<String> itemsToList(@RequestBody LinkedHashMap<String, String> itemMap){
		String itemName = itemMap.get("itemName");
		int cost = Integer.parseInt(itemMap.get("cost"));
		String itemType = itemMap.get("itemType");
		int quantity = Integer.parseInt(itemMap.get("quantity"));
		if((itemName != null) && (cost > 0) && (itemType != null) && (quantity > 0)) {
			giServ.saveItem(itemName, cost, itemType, quantity);
			return new ResponseEntity<>("Item added to list", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}	
	
	@DeleteMapping("/items/{itemId}")
	public ResponseEntity<String> removeItemById(@PathVariable("itemId") int itemId){
		GroceryItem item = giServ.getGroceryItemById(itemId);
		if(item != null) {
			giServ.removeItem(item);
			return new ResponseEntity<>("Item removed from the list", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>("Item not in the list", HttpStatus.NOT_FOUND);
	}
	
	
}
