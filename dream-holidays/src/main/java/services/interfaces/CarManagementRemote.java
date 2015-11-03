package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Car;
import entities.Client;
import entities.Contract;
import entities.ContractId;

@Remote
public interface CarManagementRemote {
	
	
	Boolean AddCar(Car car);
	Boolean DeleteCar(Integer id);
	Boolean UpdateCar(Integer id,String newModel, String newMark);
	
	Boolean addClient(Client client);
	Boolean addContract(Contract contract);
	Boolean deleteContract(Integer id);
	
	List<Car> findAllCars();
	Car findCarById(int id);
	List<Car> findCarByModel(String model);
	List<Car> findCarByMark(String mark);
	List<String> findAllModelsOfCar();
	List<String> findAllMarkOfCar();
	
	List<Contract> findAllContracts();
	Contract findContractById(ContractId contratId);
	List<Contract> findContractsByCarId(Integer id);
	List<Contract> findContractsByCarMark(String mark);
	List<Contract> findContractsByCarModel(String model);
	
	
	
}
