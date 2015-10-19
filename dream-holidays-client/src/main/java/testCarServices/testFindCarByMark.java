package testCarServices;

import java.util.List;

import delegate.CarManagementDelegate;
import entities.Car;

public class testFindCarByMark {

	public static void main(String[] args) {
		List<Car> cars=CarManagementDelegate.doFindCarByMark("Volkswagen");
		for (Car car : cars) {
			System.out.println(car.getMark());
		}

	}

}
