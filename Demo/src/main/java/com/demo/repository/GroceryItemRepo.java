package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.GroceryItem;

public interface GroceryItemRepo extends JpaRepository<GroceryItem, Integer>{
	public GroceryItem findById(int id);
	public List<GroceryItem> findAll();
}
