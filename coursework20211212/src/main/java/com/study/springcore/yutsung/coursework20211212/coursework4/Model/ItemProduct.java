package com.study.springcore.yutsung.coursework20211212.coursework4.Model;

public class ItemProduct {
	private Integer id;
	private String text;
	private Integer price;
	private Integer inventory;
	
	public ItemProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemProduct(String text, Integer price, Integer inventory) {
		super();
		this.text = text;
		this.price = price;
		this.inventory = inventory;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
}
