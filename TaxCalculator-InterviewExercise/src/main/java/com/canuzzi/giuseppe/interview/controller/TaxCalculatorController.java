package com.canuzzi.giuseppe.interview.controller;



import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Preconditions;

import com.canuzzi.giuseppe.interview.businesslogic.TaxCalculationException;
import com.canuzzi.giuseppe.interview.businesslogic.TaxRuleException;
import com.canuzzi.giuseppe.interview.businesslogic.TaxRuleManager;
import com.canuzzi.giuseppe.interview.businesslogic.TaxedGood;
import com.canuzzi.giuseppe.interview.dal.IDataSource;
import com.canuzzi.giuseppe.interview.domain.entity.Good;
import com.canuzzi.giuseppe.interview.view.IView;

public class TaxCalculatorController implements ITaxController{

	private final IDataSource model;
	private TaxRuleManager taxRuleManager;
	private IView taxView;
			
	public TaxCalculatorController(IDataSource model, IView taxView, TaxRuleManager taxRuleManager) {
		
		Preconditions.checkNotNull(model);
		Preconditions.checkNotNull(taxRuleManager);
		
		this.model = model;
		this.taxRuleManager = taxRuleManager;
		this.taxView = taxView;
	}
	
	//TODO Tax calculation
	@Override
	public void calculateTax()  throws Exception{
				
		List<Good> goodsToTax = this.model.getAllProducts();
		
		List<TaxedGood> taxedProductList = getTaxedProducts(goodsToTax);

		updateUI();
		
	}

	
	private void updateUI() {
		
	}
	
	private List<TaxedGood> getTaxedProducts(List<Good> goodsToTax) throws Exception {
		
		List<TaxedGood> taxedProductList = Lists.newArrayList();
		
		try {
			
			for (Good good : goodsToTax) {			
				TaxedGood tg = taxRuleManager.getTaxedGood(good);
				taxedProductList.add(tg);
			}
			
		}catch(Exception ex) {
			//Log that an error occurred while taxing good 
			//and rethrow because i can't release a receipt with wrong data.
			//An ipothetical framework could handle the controller exception
			
			throw ex;
		}
		
		return taxedProductList;
	}


}
