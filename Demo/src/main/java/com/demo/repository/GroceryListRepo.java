package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.GroceryList;

public interface GroceryListRepo extends JpaRepository<GroceryList, Integer>{
	public GroceryList findById(int id);
	public List<GroceryList> findAll();
	public GroceryList findByListName(String listName);
	
}
