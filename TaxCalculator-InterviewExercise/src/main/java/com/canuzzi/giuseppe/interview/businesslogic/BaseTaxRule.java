package com.canuzzi.giuseppe.interview.businesslogic;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.assertj.core.util.Preconditions;

import com.canuzzi.giuseppe.interview.domain.entity.Category;

public class BaseTaxRule implements ITaxRule<TaxedGood> {

	//TODO Retrieve its value from DB to inject inside the rule
	private final static BigDecimal baseTaxRate = new BigDecimal(10);
		
	@Override
	public void apply(TaxedGood taxableGood) {
		
		Preconditions.checkNotNull(taxableGood);

		if (taxableGood.getBasePrice() == 0) {
			return;
		}
		
		if(Category.OTHER.equals(taxableGood.getCategory())) {
			//BigDecimal for precision
			
			BigDecimal previousTaxPercentageApplied = new BigDecimal(taxableGood.getTaxPercentageApplied());
			
			BigDecimal newPercentageToApply = previousTaxPercentageApplied.add(baseTaxRate);
			
			BigDecimal newTaxedPrice = new BigDecimal(taxableGood.getBasePrice()).multiply(newPercentageToApply)
																.divide(new BigDecimal(100));
			
			BigDecimal roundedTaxValue = TaxRoundHelper.roundUpNearest(newTaxedPrice,
																	 new BigDecimal("0.05"), 
																	 RoundingMode.UP);
			
			taxableGood.setTaxPercentageApplied(newPercentageToApply.doubleValue());
			
			taxableGood.setTaxedPrice(roundedTaxValue.doubleValue());
		}

	}

}
