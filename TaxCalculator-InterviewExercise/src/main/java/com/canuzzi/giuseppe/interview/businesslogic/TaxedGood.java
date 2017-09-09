package com.canuzzi.giuseppe.interview.businesslogic;

import com.canuzzi.giuseppe.interview.domain.entity.Good;

public class TaxedGood  extends Good implements ITaxable {

	private double taxedPrice;
	private double totalTaxValue;
	
	public double getTaxedPrice() {
		return taxedPrice;
	}
	public void setTaxedPrice(double taxedPrice) {
		this.taxedPrice = taxedPrice;
	}
	public double getTotalTaxValue() {
		return (taxedPrice - basePrice);
	}
	
}
