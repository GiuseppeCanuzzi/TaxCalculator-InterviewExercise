package com.canuzzi.giuseppe.interview.businesslogic.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.canuzzi.giuseppe.interview.businesslogic.BaseTaxRule;
import com.canuzzi.giuseppe.interview.businesslogic.IRuleEngine;
import com.canuzzi.giuseppe.interview.businesslogic.ITaxRule;
import com.canuzzi.giuseppe.interview.businesslogic.TaxImportRule;
import com.canuzzi.giuseppe.interview.businesslogic.TaxRuleEngine;
import com.canuzzi.giuseppe.interview.businesslogic.TaxRuleManager;
import com.canuzzi.giuseppe.interview.businesslogic.TaxedGood;
import com.canuzzi.giuseppe.interview.common.test.GoodCreator;
import com.canuzzi.giuseppe.interview.domain.entity.Good;

public class TaxRuleManagerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void taxGood_ImportBookToTax_TaxedBookCreated() throws Exception {
		//Setup
		Good good = GoodCreator.getNonImportedBook(14.99);

		IRuleEngine<ITaxRule<TaxedGood>, TaxedGood> taxRuleEngine = new TaxRuleEngine();
		
		TaxImportRule importRule = new TaxImportRule();
		BaseTaxRule baseTaxRule = new BaseTaxRule();
		
		List<ITaxRule<TaxedGood>> rules = new ArrayList<>();
		
		rules.add(importRule);
		rules.add(baseTaxRule);
		
		TaxRuleManager trm = new TaxRuleManager(taxRuleEngine);
		
		//Exercise
		
		TaxedGood tg = trm.getTaxedGood(good);
		
		//Verify
		
		assertThat(tg).isNotNull();
		assertThat(tg.getTaxedPrice()).isEqualTo(good.getBasePrice());
		assertThat(tg.getTotalTaxValue()).isEqualTo(0.00);
		
	}

}
