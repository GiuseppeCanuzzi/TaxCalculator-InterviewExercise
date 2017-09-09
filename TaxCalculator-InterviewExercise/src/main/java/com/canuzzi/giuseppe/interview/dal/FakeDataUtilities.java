package com.canuzzi.giuseppe.interview.dal;

import java.util.List;

import org.assertj.core.util.Lists;

import com.canuzzi.giuseppe.interview.domain.entity.Good;

/**
 * This class return a list of Product based on input type requested by this exercise
 * In a real scenario this products could be retrieved from a database 
 * 
 * @author giuseppecanuzzi
 *
 */
public class FakeDataUtilities {
	
	public static List<Good> createProductList(InputType inputType){
		
		List<Good> products = Lists.newArrayList();
		
		Good p1 = new Good();
		Good p2 = new Good();
		Good p3 = new Good();
		Good p4 = new Good();
		
		switch(inputType) {
		
		case FIRST:
			return Lists.newArrayList(p1, p2 ,p3);
		case SECOND:
			return Lists.newArrayList(p1, p2 ,p3);
		case THIRD:
			return Lists.newArrayList(p1, p2 , p3, p4);
		default:
			return products;
		}
	}

}
