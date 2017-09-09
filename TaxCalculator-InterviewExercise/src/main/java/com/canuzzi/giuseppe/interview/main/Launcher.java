package com.canuzzi.giuseppe.interview.main;

import com.canuzzi.giuseppe.interview.dal.FakeDataSourceFactory;
import com.canuzzi.giuseppe.interview.dal.IDataSource;
import com.canuzzi.giuseppe.interview.dal.InputType;

public class Launcher {

	public static void main(String[] args) {
		
		
		//TODO Retrieve goods from cart or other data sources (db)
		IDataSource dataSource = FakeDataSourceFactory.getCart(InputType.FIRST);
		
		//TODO Create a controller for tax calculation, the controller could have a reference to an outputter object (i.e a view, printer)
		
		
		
		//TODO Print the final receipt
	}

}
