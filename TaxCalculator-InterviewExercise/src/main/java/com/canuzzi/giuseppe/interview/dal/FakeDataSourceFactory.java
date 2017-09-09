package com.canuzzi.giuseppe.interview.dal;

import java.util.List;

import com.canuzzi.giuseppe.interview.domain.entity.Product;

/**
 * A factory to retrieve a mocked data source for the product
 * @author giuseppecanuzzi
 *
 */

public class FakeDataSourceFactory {
	
	public static IDataSource getCart(InputType inputType) {
		
		List<Product> productListToInitCart = FakeDataUtilities.createProductList(inputType);
		
		ShoppingCart shoppingCart = new ShoppingCart(productListToInitCart);
		
		return shoppingCart;
	}

}
