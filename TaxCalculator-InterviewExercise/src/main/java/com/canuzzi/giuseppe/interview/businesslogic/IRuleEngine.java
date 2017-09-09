package com.canuzzi.giuseppe.interview.businesslogic;

import java.util.List;

public interface IRuleEngine<T extends IRule, E extends IEvaluable> {

	public E applyRules(List<T> rules, E evaluable);
	
}
