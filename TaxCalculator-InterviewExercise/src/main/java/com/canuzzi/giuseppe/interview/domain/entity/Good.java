package com.canuzzi.giuseppe.interview.domain.entity;

public class Good {
	
	protected boolean isImport;
	protected String description;
	protected String name;
	protected double basePrice;
	protected Category category;
	
	public boolean isImport() {
		return isImport;
	}
	public void setImport(boolean isImport) {
		this.isImport = isImport;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

}
