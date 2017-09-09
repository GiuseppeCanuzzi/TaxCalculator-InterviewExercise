package com.canuzzi.giuseppe.interview.main;

import com.canuzzi.giuseppe.interview.controller.ITaxController;
import com.canuzzi.giuseppe.interview.controller.TaxCalculatorController;
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
		//TODO Could add Guice to manage dependency injection to centralize config even more if config will growth in the future
		//ITaxController controller = new TaxCalculatorController();
		
		
	}

}
