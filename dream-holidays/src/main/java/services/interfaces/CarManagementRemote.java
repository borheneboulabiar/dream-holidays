package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Car;
import entities.Contract;

@Remote
public interface CarManagementRemote {

	Boolean AddCar(Car car);
	List<Car> findAllCars();
	Car findCarById(int id);
	List<Car> findCarByModel(String model);
	List<Car> findCarByMark(String mark);
	
	List<Contract> findAllContracts();
	List<Contract> findContractsByCarId(Integer id);
	List<Contract> findContractsByCarMark(String mark);
	List<Contract> findContractsByCarModel(String model);
	
	Boolean addContract(Contract contract);
	
}
