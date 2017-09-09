package com.canuzzi.giuseppe.interview.data.mock;

import java.util.List;

import com.canuzzi.giuseppe.interview.domain.entity.Product;

public interface IDataSource {
	
	public List<Product> getAllProducts();

}
