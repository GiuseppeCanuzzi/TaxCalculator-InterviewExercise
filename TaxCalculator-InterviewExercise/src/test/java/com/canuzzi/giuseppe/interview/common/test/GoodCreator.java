package com.canuzzi.giuseppe.interview.common.test;

import com.canuzzi.giuseppe.interview.domain.entity.Category;
import com.canuzzi.giuseppe.interview.domain.entity.Good;

public class GoodCreator {
	
	public static Good getNonImportedBook(double basePrice){
		
		Good good = new Good();
		
		good.setBasePrice(basePrice);
		good.setCategory(Category.BOOK);
		good.setImport(false);
		good.setName("book");
		good.setDescription("some description");
		
		return good;
	}
	
public static Good getImportedFood(double basePrice){
		
		Good good = new Good();
		
		good.setBasePrice(basePrice);
		good.setCategory(Category.FOOD);
		good.setImport(true);
		good.setName("food");
		good.setDescription("some description");
		
		return good;
	}

public static Good getNonImportedFood(double basePrice){
	
	Good good = new Good();
	
	good.setBasePrice(basePrice);
	good.setCategory(Category.FOOD);
	good.setImport(true);
	good.setName("food");
	good.setDescription("some description");
	
	return good;
}

public static Good getNonImportedMedical(double basePrice){
	
	Good good = new Good();
	
	good.setBasePrice(basePrice);
	good.setCategory(Category.MEDICAL);
	good.setImport(false);
	good.setName("medical");
	good.setDescription("some description");
	
	return good;
}

public static Good getNonImportedGeneralGood(double basePrice){
	
	Good good = new Good();
	
	good.setBasePrice(basePrice);
	good.setCategory(Category.OTHER);
	good.setImport(false);
	good.setName("parfume");
	good.setDescription("some description");
	
	return good;
}

public static Good getImportedGeneralGood(double basePrice){
	
	Good good = new Good();
	
	good.setBasePrice(basePrice);
	good.setCategory(Category.OTHER);
	good.setImport(true);
	good.setName("parfume");
	good.setDescription("some description");
	
	return good;
}

}
