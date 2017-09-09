package com.canuzzi.giuseppe.interview.controller;



import java.util.List;

import org.apache.commons.lang3.NotImplementedException;

import com.canuzzi.giuseppe.interview.businesslogic.TaxRuleManager;
import com.canuzzi.giuseppe.interview.businesslogic.TaxedGood;
import com.canuzzi.giuseppe.interview.dal.IDataSource;

public class TaxCalculatorController implements ITaxController{

	private final IDataSource model;
	
	private TaxRuleManager taxRuleManager;
	private List<TaxedGood> taxedProductList;

			
	public TaxCalculatorController(IDataSource model, TaxRuleManager taxRuleManager) {	
		this.model = model;
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
