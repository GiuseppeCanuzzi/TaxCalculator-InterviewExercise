package com.canuzzi.giuseppe.interview.businesslogic;

import java.util.List;

import org.assertj.core.util.Preconditions;

public class TaxRuleEngine implements IRuleEngine<ITaxRule, ITaxable> {

	@Override
	public ITaxable applyRules(List<ITaxRule> rules, ITaxable evaluable) {
		Preconditions.checkNotNull(rules, "Invalid rules provided");
		Preconditions.checkNotNull(evaluable, "Invalid value to evaluate");
		// TODO Auto-generated method stub
		return new TaxedGood();
	}

}
