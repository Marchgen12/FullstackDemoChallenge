package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.GroceryItem;
import com.demo.model.GroceryList;
import com.demo.repository.GroceryListRepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor(onConstructor=@__(@Autowired))
@NoArgsConstructor
public class GroceryListService {

	private GroceryListRepo glRepo;
	
	public GroceryList getGroceryListById(int id) {
		GroceryList list = glRepo.findById(id);
		if(list == null) {
			throw new NullPointerException();
		}
		return list;
	}
	
	public List<GroceryList> getAllList(){
		List<GroceryList> gList = glRepo.findAll();
		if(gList.size() == 0) {
			throw new NullPointerException();
		}
		return gList;
	}
	
	public GroceryList getGroceryListByName(String listName) {
		GroceryList list = glRepo.findByListName(listName);
		if(list == null) {
			throw new NullPointerException();
		}
		return list;
	}
	
	public void saveList(String listName) {
		GroceryList list = new GroceryList();
		list.setListName(listName);
		glRepo.save(list);
	}
	
	public void deleteList(GroceryList list) {
		glRepo.delete(list);
	}
}
