package com.canuzzi.giuseppe.interview.data.mock;

import java.util.List;

import org.assertj.core.util.Lists;

import com.canuzzi.giuseppe.interview.domain.entity.Product;

/**
 * This class return a list of Product based on input type requested by this exercise
 * In a real scenario this products could be retrieved from a database 
 * 
 * @author giuseppecanuzzi
 *
 */
public class FakeDataUtilities {
	
	public static List<Product> createProductList(InputType inputType){
		
		List<Product> products = Lists.newArrayList();
		
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		Product p4 = new Product();
		
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
