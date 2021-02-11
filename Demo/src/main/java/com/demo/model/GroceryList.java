package com.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="GroceryList")
public class GroceryList {

	@Id
	@Column(name="list_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	private int listId;
	
	@Column(name="list_name")
	private String listName;
	
	public GroceryList(String listName) {
		this.listName = listName;
	}

	@Override
	public String toString() {
		return "GroceryList [listId=" + listId + ", listName=" + listName + "]";
	}

	
}
