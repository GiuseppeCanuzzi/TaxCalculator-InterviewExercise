package com.canuzzi.giuseppe.interview.businesslogic;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.assertj.core.util.Preconditions;

import com.canuzzi.giuseppe.interview.domain.entity.Category;

public class BaseTaxRule implements ITaxRule<TaxedGood> {

	//TODO Retrieve its value from DB to inject inside the rule
	private final static BigDecimal baseTaxRate = new BigDecimal(10);
		
	@Override
	public void apply(TaxedGood taxableGood) throws TaxCalculationException {
		
		Preconditions.checkNotNull(taxableGood, "Cannot apply tax to a null good");
		
		BigDecimal basePrice = taxableGood.getBasePrice();
		
		if(basePrice.signum() == -1) {
			throw new TaxCalculationException(String.format(
														"Negative base price is invalid for tax calculation of %s : %s", 
														taxableGood.getName(),
														taxableGood.getDescription())
											);
		}

		if (taxableGood.getBasePrice().signum() == 0) {
			return;
		}
		
		
		if(Category.OTHER.equals(taxableGood.getCategory())) {
			
			//BigDecimal for precision
			
			BigDecimal previousTaxPercentageApplied = taxableGood.getTaxPercentageApplied();
			
			BigDecimal newPercentageToApply = previousTaxPercentageApplied.add(baseTaxRate);
					
			BigDecimal taxValue = basePrice.multiply(newPercentageToApply)
																.divide(new BigDecimal(100));
			
			BigDecimal roundedTaxValue = TaxRoundHelper.roundUpNearest(taxValue,
																	 new BigDecimal(String.valueOf(RoundValue.NEAREST_TO_5_CENTS)), 
																	 RoundingMode.UP);
			
			taxableGood.setTaxPercentageApplied(newPercentageToApply);
			
			BigDecimal taxedPrice = roundedTaxValue.add(basePrice);
			
			taxableGood.setTaxedPrice(taxedPrice);
		}

	}

}
