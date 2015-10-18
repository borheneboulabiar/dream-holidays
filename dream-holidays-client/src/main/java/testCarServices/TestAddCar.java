package testCarServices;

import delegate.CarManagementDelegate;
import entities.Car;

public class TestAddCar {

	public static void main(String[] args) {
		Car car = new Car();
		car.setMark("Volkswagen");
		car.setModel("Polo4");
		
		CarManagementDelegate.getProxy().AddCar(car);

	}

}
