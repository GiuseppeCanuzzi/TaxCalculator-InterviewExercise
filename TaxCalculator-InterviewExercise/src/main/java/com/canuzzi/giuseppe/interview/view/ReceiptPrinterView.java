package com.canuzzi.giuseppe.interview.view;

import java.math.BigDecimal;
import java.util.List;

import org.assertj.core.util.Preconditions;

import com.canuzzi.giuseppe.interview.businesslogic.TaxedGood;

public class ReceiptPrinterView {

	public String printReceipt(List<TaxedGood> elemToPrint) {
		
		Preconditions.checkNotNull(elemToPrint,"List of elements to print is null");
		
		StringBuilder receiptBuilder = new StringBuilder();
		BigDecimal totalReceipt = BigDecimal.ZERO;
		BigDecimal totalTaxes = BigDecimal.ZERO;
		
		for (TaxedGood taxedGood : elemToPrint) {
			
			String printedElem = String.format("1%s %s : %s\n", taxedGood.isImport() ? " imported" : "",
															taxedGood.getName(), 
															String.valueOf(taxedGood.getTaxedPrice().doubleValue()));
			
			receiptBuilder.append(printedElem);
			totalReceipt = totalReceipt.add(taxedGood.getTaxedPrice());
			totalTaxes = totalTaxes.add(taxedGood.getTotalTaxValue());
		}
		
		receiptBuilder.append(String.format("Sales Taxes: %s\n", String.valueOf(totalTaxes.doubleValue())));
		receiptBuilder.append(String.format("Total : %s\n", String.valueOf(totalReceipt.doubleValue())));
		
		
		String receipt = receiptBuilder.toString();
		
		System.out.println(receipt);
		
		return receipt;
		
	}
	

}
