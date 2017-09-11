package com.canuzzi.giuseppe.interview.view.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.canuzzi.giuseppe.interview.businesslogic.TaxedGood;
import com.canuzzi.giuseppe.interview.common.test.GoodCreator;
import com.canuzzi.giuseppe.interview.view.ReceiptPrinterView;
import com.google.common.collect.Lists;

public class ReceiptPrinterViewTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void printReceipt_VerifyFormatting_ReceiptPrinted() {
		
		//Setup
		ReceiptPrinterView receiptPrinter = new ReceiptPrinterView();
		
		TaxedGood nonImportedGenericGood = GoodCreator.getNonImportedGeneralTaxedGood(18.99);
		nonImportedGenericGood.setTaxedPrice(new BigDecimal(String.valueOf("20.89")));
		
		TaxedGood importedGenericGood = GoodCreator.getImportedGeneralTaxedGood(27.99);
		importedGenericGood.setTaxedPrice(new BigDecimal(String.valueOf("32.19")));
		
		TaxedGood nonImportedMedicalGood = GoodCreator.getNonImportedTaxedMedical(9.75);
		nonImportedMedicalGood.setTaxedPrice(new BigDecimal(String.valueOf("9.75")));
		
		TaxedGood importedFoodGood = GoodCreator.getImportedTaxedBook(11.25);
		importedFoodGood.setTaxedPrice(new BigDecimal(String.valueOf("11.85")));
		
		
		List<TaxedGood> taxedGoodToPrint = Lists.newArrayList(nonImportedGenericGood,nonImportedMedicalGood, importedFoodGood, importedGenericGood);
		
		//Exercise
		
		String receipt = receiptPrinter.printReceipt(taxedGoodToPrint);
		
		//Verify
		
		assertThat(receipt).isEqualTo("1 parfume : 20.89\n" + 
									  "1 medical : 9.75\n" + 
									  "1 imported book : 11.85\n" + 
									  "1 imported parfume : 32.19\n" + 
									  "Sales Taxes: 6.7\n" + 
									  "Total : 74.68\n");
		
			
	}
	
	@Test
	public void printReceipt_TotalFormatWhenTaxedPriceHavingMorePrecision_PrecisionIsMaintained() {
		//Setup
		ReceiptPrinterView receiptPrinter = new ReceiptPrinterView();
		
		TaxedGood nonImportedGenericGood = GoodCreator.getNonImportedGeneralTaxedGood(18.9999);
		nonImportedGenericGood.setTaxedPrice(new BigDecimal(String.valueOf("20.8999")));
		
		TaxedGood importedGenericGood = GoodCreator.getImportedGeneralTaxedGood(27.99);
		importedGenericGood.setTaxedPrice(new BigDecimal(String.valueOf("32.19")));
		
		TaxedGood nonImportedMedicalGood = GoodCreator.getNonImportedTaxedMedical(9.75);
		nonImportedMedicalGood.setTaxedPrice(new BigDecimal(String.valueOf("9.75")));
		
		TaxedGood importedFoodGood = GoodCreator.getImportedTaxedBook(11.25);
		importedFoodGood.setTaxedPrice(new BigDecimal(String.valueOf("11.85")));
		
		
		List<TaxedGood> taxedGoodToPrint = Lists.newArrayList(nonImportedGenericGood,nonImportedMedicalGood, importedFoodGood, importedGenericGood);
		
		//Exercise
		
		String receipt = receiptPrinter.printReceipt(taxedGoodToPrint);
		
		//Verify
		
		assertThat(receipt).isEqualTo("1 parfume : 20.8999\n" + 
									  "1 medical : 9.75\n" + 
									  "1 imported book : 11.85\n" + 
									  "1 imported parfume : 32.19\n" + 
									  "Sales Taxes: 6.7\n" + 
									  "Total : 74.6899\n");
		
	}
	
	@Test
	public void prntReceipt_FormatWhenTaxedPriceIsSetWithoutBigDecimalStringConstructor_PrecisionMaintained() {
		// Setup
		ReceiptPrinterView receiptPrinter = new ReceiptPrinterView();

		TaxedGood nonImportedGenericGood = GoodCreator.getNonImportedGeneralTaxedGood(18.9999);
		nonImportedGenericGood.setTaxedPrice(new BigDecimal(20.8999));

		TaxedGood importedGenericGood = GoodCreator.getImportedGeneralTaxedGood(27.99);
		importedGenericGood.setTaxedPrice(new BigDecimal(32.19));

		TaxedGood nonImportedMedicalGood = GoodCreator.getNonImportedTaxedMedical(9.75);
		nonImportedMedicalGood.setTaxedPrice(new BigDecimal(9.75));

		TaxedGood importedFoodGood = GoodCreator.getImportedTaxedBook(11.25);
		importedFoodGood.setTaxedPrice(new BigDecimal(11.85));

		List<TaxedGood> taxedGoodToPrint = Lists.newArrayList(nonImportedGenericGood, nonImportedMedicalGood,
				importedFoodGood, importedGenericGood);

		// Exercise

		String receipt = receiptPrinter.printReceipt(taxedGoodToPrint);

		// Verify

		assertThat(receipt).isEqualTo("1 parfume : 20.8999\n" +
									 "1 medical : 9.75\n" +
									 "1 imported book : 11.85\n"+
									 "1 imported parfume : 32.19\n" +
									 "Sales Taxes: 6.7\n" + 
									 "Total : 74.6899\n");
	}
	
	@Test
	public void printReceipt_NullInput_ExceptionRaised(){
		//Setup
		ReceiptPrinterView receiptPrinter = new ReceiptPrinterView();
		List<TaxedGood> taxedGoodToPrint = null;
		
		
		
		//Verify
		assertThatThrownBy(//Exercise
							() -> receiptPrinter.printReceipt(taxedGoodToPrint)
						  ).isInstanceOf(NullPointerException.class)
						   .hasMessage("List of elements to print is null");
	}
	
	@Test
	public void printReceipt_EmptyList_PrintZeroTotalAndTaxes() {
		// Setup
		ReceiptPrinterView receiptPrinter = new ReceiptPrinterView();
		List<TaxedGood> taxedGoodToPrint = Lists.newArrayList();
		
		//Exercise
		String emptyReceipt = receiptPrinter.printReceipt(taxedGoodToPrint);
		
		//Verify
				assertThat(emptyReceipt).isEqualTo("Sales Taxes: 0.0\n" + 
												  "Total : 0.0\n");
	}

}
