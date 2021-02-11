package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="GroceryItem")
public class GroceryItem {

	@Id
	@Column(name="item_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter(AccessLevel.NONE)
	private int itemId;
	
	@Column(name="item_name")
	private String itemName;

	@Column(name="cost")
	private int cost;
	
	@Column(name="item_type")
	private String itemType;
	
	@Column(name="quantity")
	private int quantity;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="list_id")
	private GroceryList list;

	public GroceryItem(String itemName, int cost, String itemType, int quantity) {
		super();
		this.itemName = itemName;
		this.cost = cost;
		this.itemType = itemType;
		this.quantity = quantity;
	}
	
	public GroceryItem(String itemName, int cost, String itemType, int quantity, GroceryList list) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.cost = cost;
		this.itemType = itemType;
		this.quantity = quantity;
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "GroceryItem [itemId=" + itemId + ", itemName=" + itemName + ", cost=" + cost + ", type=" + itemType
				+ ", quantity=" + quantity + "]";
	}

}
