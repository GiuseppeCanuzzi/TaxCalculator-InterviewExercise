package com.canuzzi.giuseppe.interview.businesslogic;

import java.util.List;

import org.assertj.core.util.Preconditions;

public class TaxRuleEngine implements IRuleEngine<ITaxRule<TaxedGood>, TaxedGood> {

	@Override
	public void applyRules(List< ITaxRule<TaxedGood> > rules, TaxedGood evaluable) throws Exception {
		
		Preconditions.checkNotNull(rules, "Cannot apply rules if there are any");
		Preconditions.checkNotNull(evaluable, "Cannot apply rules if no evaluable subject is specified");
		
		for (ITaxRule<TaxedGood> rule : rules) {
			rule.apply(evaluable);
		}
		
	}

}
