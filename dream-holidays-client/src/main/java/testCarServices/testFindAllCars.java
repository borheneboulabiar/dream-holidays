package testCarServices;

import java.util.List;

import delegate.CarManagementDelegate;
import entities.Car;

public class testFindAllCars {

	public static void main(String[] args) {
		System.out.println("Get All Cars");
		List<Car> cars = CarManagementDelegate.doFindAllCars();
		for (Car car : cars) {
			System.out.println("Num Car : "+ car.getId());
			System.out.println("Mark : " + car.getMark());
			System.out.println("Model : " + car.getModel());
		}

	}

}
