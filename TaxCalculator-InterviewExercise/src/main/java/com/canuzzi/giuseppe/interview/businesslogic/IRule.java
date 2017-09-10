package com.canuzzi.giuseppe.interview.businesslogic;

public interface IRule<T extends IEvaluable> {
	
	public void apply(T acceptedType);

}
