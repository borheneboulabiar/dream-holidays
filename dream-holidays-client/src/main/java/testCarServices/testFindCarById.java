package testCarServices;

import delegate.CarManagementDelegate;

public class testFindCarById {

	public static void main(String[] args) {
		
		System.out.println("Car : "+CarManagementDelegate.getProxy().findCarById(1).getModel());

	}

}
