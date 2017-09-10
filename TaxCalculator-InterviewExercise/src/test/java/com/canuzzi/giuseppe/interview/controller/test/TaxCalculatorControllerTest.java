package com.canuzzi.giuseppe.interview.controller.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.canuzzi.giuseppe.interview.common.test.GoodCreator;
import com.canuzzi.giuseppe.interview.domain.entity.Category;
import com.canuzzi.giuseppe.interview.domain.entity.Good;

public class TaxCalculatorControllerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void calculateTax_OnBooksNotImported_NoTaxApplied() {
		
		//Setup
		Good product = GoodCreator.getNonImportedBook(14.99);
		
		
		//Exercise
		
		
		//Verify
		
	}
	

}
