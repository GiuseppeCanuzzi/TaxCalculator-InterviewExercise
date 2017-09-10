package com.canuzzi.giuseppe.interview.businesslogic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxRoundHelper {

	public static BigDecimal roundUpNearest(BigDecimal value, BigDecimal increment, RoundingMode roundingMode) {
		
		if (increment.signum() == 0) {
			return value;
		} else {
			BigDecimal divided = value.divide(increment, 2, roundingMode);
			BigDecimal result = divided.multiply(increment);
			return result.setScale(2);
		}
	}

}
