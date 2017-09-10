package com.canuzzi.giuseppe.interview.businesslogic;

import java.math.BigDecimal;

import com.canuzzi.giuseppe.interview.domain.entity.Good;

public class TaxedGood  extends Good implements ITaxable {

	private BigDecimal taxedPrice;
	private BigDecimal taxPercentageApplied;
	
	public TaxedGood() {
		super();
		taxedPrice = BigDecimal.ZERO;
		taxPercentageApplied = BigDecimal.ZERO;
	}
	
	public BigDecimal getTaxedPrice() {
		return taxedPrice;
	}
	
	public void setTaxedPrice(BigDecimal taxedPrice) {
		this.taxedPrice = taxedPrice;
	}
	
	public BigDecimal getTotalTaxValue() {
		if(BigDecimal.ZERO.compareTo(taxedPrice) == 0) {
			return BigDecimal.ZERO;
		}
		return taxedPrice.subtract(basePrice);
	}
	
	public BigDecimal getTaxPercentageApplied() {
		return taxPercentageApplied;
	}
	
	public void setTaxPercentageApplied(BigDecimal taxPercentageApplied) {
		this.taxPercentageApplied = taxPercentageApplied;
	}
	
	
	
}
