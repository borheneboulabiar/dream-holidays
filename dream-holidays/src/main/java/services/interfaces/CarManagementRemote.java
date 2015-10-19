package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Car;

@Remote
public interface CarManagementRemote {

	Boolean AddCar(Car car);
	List<Car> findAllCars();
	Car findCarById(int id);
	List<Car> findCarByModel(String model);
	List<Car> findCarByMark(String mark);
}
