package com.canuzzi.giuseppe.interview.controller;



import java.util.List;

import org.apache.commons.lang3.NotImplementedException;

import com.canuzzi.giuseppe.interview.businesslogic.TaxRuleManager;
import com.canuzzi.giuseppe.interview.businesslogic.TaxedGood;

public class TaxCalculatorController implements ITaxController{

	private TaxRuleManager taxRuleManager;
	private List<TaxedGood> taxedProductList;
			
	public TaxCalculatorController(TaxRuleManager taxRuleManager) {
		// TODO Auto-generated constructor stub
		this.taxRuleManager = taxRuleManager;
	}
	//TODO Tax calculation
	@Override
	public void calculateTax() {
		//taxRuleManager.getTaxedGood
		
	}

	//TODO Tax outputter (UI udpdate)
	@Override
	public void updateUI() {
		throw new NotImplementedException("Not implementd");		
	}
	
	

}
