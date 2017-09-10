package com.canuzzi.giuseppe.interview.businesslogic;

import java.util.List;

import org.assertj.core.util.Lists;
import org.assertj.core.util.Preconditions;

import com.canuzzi.giuseppe.interview.domain.entity.Good;

public class TaxRuleManager{
	
	private List<ITaxRule<TaxedGood>> taxRuleList;
	private IRuleEngine<ITaxRule<TaxedGood>, TaxedGood> taxRuleEngine;
	
	public TaxRuleManager(IRuleEngine<ITaxRule<TaxedGood>, TaxedGood> taxRuleEngine) {
		
		Preconditions.checkNotNull(taxRuleEngine);
		
		this.taxRuleList = Lists.newArrayList();
		this.taxRuleEngine = taxRuleEngine;
	}
	
	
	public TaxedGood getTaxedGood(Good good) throws Exception {
		
		Preconditions.checkNotNull(good);
		
		TaxedGood taxedGood = new TaxedGood();
		
		taxedGood.setBasePrice(good.getBasePrice());
		taxedGood.setCategory(good.getCategory());
		taxedGood.setDescription(good.getDescription());
		taxedGood.setImport(good.isImport());
		taxedGood.setName(good.getName());
		
		taxRuleEngine.applyRules(taxRuleList, taxedGood);
		
		return taxedGood;
		
	}

}
