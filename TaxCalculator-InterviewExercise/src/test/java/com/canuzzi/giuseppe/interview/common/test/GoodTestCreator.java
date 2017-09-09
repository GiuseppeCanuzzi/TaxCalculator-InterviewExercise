package com.canuzzi.giuseppe.interview.common.test;

import com.canuzzi.giuseppe.interview.domain.entity.Category;
import com.canuzzi.giuseppe.interview.domain.entity.Good;

public class GoodTestCreator {
	
	public static Good getNonImportedBook(double basePrice){
		
		Good good = new Good();
		
		good.setBasePrice(basePrice);
		good.setCategory(Category.BOOK);
		good.setImport(false);
		good.setName("book");
		good.setDescription("some description");
		
		return good;
	}

}
