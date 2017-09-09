package com.canuzzi.giuseppe.interview.main;

import com.canuzzi.giuseppe.interview.data.mock.FakeDataSourceFactory;
import com.canuzzi.giuseppe.interview.data.mock.IDataSource;
import com.canuzzi.giuseppe.interview.data.mock.InputType;

public class Launcher {

	public static void main(String[] args) {
		
		
		//TODO Retrieve goods from cart or other data sources (db)
		IDataSource dataSource = FakeDataSourceFactory.getCart(InputType.FIRST);
		
		//TODO Send goods to our tax calculator
		
		//TODO Print the final receipt
	}

}
