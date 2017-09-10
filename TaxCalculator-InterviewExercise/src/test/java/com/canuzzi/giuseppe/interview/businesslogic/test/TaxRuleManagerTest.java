package com.canuzzi.giuseppe.interview.businesslogic.test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
	public void taxGood_TaxFreeGood_NoTaxApplied() {
		//Setup
		Good good = GoodCreator.getNonImportedBook(14.99);
		
		TaxedGood taxedGoodResult = new TaxedGood();
		
		taxedGoodResult.setBasePrice(good.getBasePrice());
		taxedGoodResult.setCategory(good.getCategory());
		taxedGoodResult.setDescription(good.getDescription());
		taxedGoodResult.setImport(good.isImport());
		taxedGoodResult.setName(good.getName());
		taxedGoodResult.setTaxedPrice(good.getBasePrice());

		TaxRuleEngine taxRuleEngine = Mockito.mock(TaxRuleEngine.class);
		//Mockito.dowhen(taxRuleEngine.applyRules(Lists.newArrayList(), Mockito.any(TaxedGood.class)));
		
		TaxRuleManager trm = new TaxRuleManager(taxRuleEngine);
		
		//Exercise
		
		TaxedGood tg = trm.getTaxedGood(good);
		
		//Verify
		
		assertThat(tg).isNotNull();
		assertThat(tg.getTaxedPrice()).isEqualTo(good.getBasePrice());
		assertThat(tg.getTotalTaxValue()).isEqualTo(0.00);
		
	}

}
