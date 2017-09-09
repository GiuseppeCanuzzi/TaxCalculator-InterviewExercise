package com.canuzzi.giuseppe.interview.main;

import com.canuzzi.giuseppe.interview.dal.FakeDataSourceFactory;
import com.canuzzi.giuseppe.interview.dal.IDataSource;
import com.canuzzi.giuseppe.interview.dal.InputType;

/**
 * This is the main class where i setup everything i need to run the
 * tax calculator controller
 * 
 * @author giuseppecanuzzi
 *
 */
public class Launcher {

	public static void main(String[] args) {
		
		
		//TODO Retrieve goods from cart or other data sources (db)
		IDataSource dataSource = FakeDataSourceFactory.getCart(InputType.FIRST);
		
		
		//TODO Create a controller for tax calculation, the controller could have a reference to an outputter object (i.e a view, printer)
		
		//Single point of injection for this tax calculator controller
		//TODO Adding Guice to manage dependency injection could centralize config even more for future project growth
		
	}

}
