package testCarServices;

import java.util.List;

import delegate.CarManagementDelegate;
import entities.Car;

public class testFindCarByModel {

	public static void main(String[] args) {
		List<Car> cars = CarManagementDelegate.doFindCarByModel("Polo4");
		for (Car car : cars) {
			System.out.println(car.getModel());
		}
		

	}

}
