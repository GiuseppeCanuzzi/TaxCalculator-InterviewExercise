package com.canuzzi.giuseppe.interview.view;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

import org.assertj.core.util.Preconditions;

import com.canuzzi.giuseppe.interview.businesslogic.TaxedGood;

public class ReceiptPrinterView {

	public String printReceipt(List<TaxedGood> elemToPrint) {
		
		Preconditions.checkNotNull(elemToPrint,"List of elements to print is null");
		
		StringBuilder receiptBuilder = new StringBuilder();
		BigDecimal totalReceipt = BigDecimal.ZERO;
		BigDecimal totalTaxes = BigDecimal.ZERO;
		
		elemToPrint.removeIf(Objects::isNull);
		
		
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(4);
		df.setMinimumFractionDigits(2);
		df.setGroupingUsed(false);
		
		for (TaxedGood taxedGood : elemToPrint) {
			
			String valueFormatted = df.format(taxedGood.getTaxedPrice());
			String printedElem = String.format("1%s %s : %s\n", taxedGood.isImport() ? " imported" : "",
															taxedGood.getName(), 
															valueFormatted);
			
			receiptBuilder.append(printedElem);
			
			totalReceipt = totalReceipt.add(taxedGood.getTaxedPrice()); 
			totalTaxes = totalTaxes.add(taxedGood.getTotalTaxValue());
			
		}
		
		String totalReceiptFormatted = df.format(totalReceipt.doubleValue());
		String totlaTaxesFormatted = df.format(totalTaxes.doubleValue());
		
		receiptBuilder.append(String.format("Sales Taxes: %s\n", totlaTaxesFormatted));
		receiptBuilder.append(String.format("Total : %s\n", totalReceiptFormatted));
		
		String receipt = receiptBuilder.toString();
		
		System.out.println(receipt);
		
		return receipt;
		
	}
	

}
