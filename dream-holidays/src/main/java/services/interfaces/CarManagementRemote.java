package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Car;
import entities.Client;
import entities.Contract;

@Remote
public interface CarManagementRemote {
	
	/* ADD */
	Boolean AddCar(Car car);
	Boolean addClient(Client client);
	Boolean addContract(Contract contract);
	
	/* CAR */
	List<Car> findAllCars();
	Car findCarById(int id);
	List<Car> findCarByModel(String model);
	List<Car> findCarByMark(String mark);
	List<String> findAllModelsOfCar();
	List<String> findAllMarkOfCar();
	
	
	/* CONTRACT */
	List<Contract> findAllContracts();
	List<Contract> findContractsByCarId(Integer id);
	List<Contract> findContractsByCarMark(String mark);
	List<Contract> findContractsByCarModel(String model);
	
	
	
}
