package com.canuzzi.giuseppe.interview.dal;

import java.util.List;

import org.assertj.core.util.Preconditions;

import com.canuzzi.giuseppe.interview.domain.entity.Product;
import com.google.common.collect.Lists;

/**
 * This class simulates a possible data source for the kind o data we need to calculate the tax.
 * 
 * @author giuseppecanuzzi
 *
 */
public class ShoppingCart implements IDataSource {
	
	private List<Product> productList;
	
	public List<Product> getAllProducts(){
		
		//TODO return a copy
		return productList;
			
	}
	
	public ShoppingCart() {
		this(Lists.newArrayList());
	}
	
	public ShoppingCart(List<Product> productList) {
		Preconditions.checkNotNull(productList, "Trying to add null products during initialization");
		
		this.productList = productList;
	}
	
	public boolean addProduct(Product product) {
		
		Preconditions.checkNotNull(product,"Trying to add null product");
		
		return productList.add(product);
	}
	
	public boolean addProductList(List<Product> products) {
		
		Preconditions.checkNotNull(products, "Trying to add null products");
		
		//TODO add a copy
		
		return productList.addAll(products);
	}
	

}
