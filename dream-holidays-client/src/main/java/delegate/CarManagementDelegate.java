package delegate;

import java.util.List;

import entities.Car;
import entities.Client;
import entities.Contract;
import entities.ContractId;
import locator.ServiceLocator;
import services.interfaces.CarManagementRemote;

public class CarManagementDelegate {

	public static final String jndiName = "/dream-holidays/CarManagement!services.interfaces.CarManagementRemote";
	
	public static CarManagementRemote getProxy(){
		return (CarManagementRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}
	
	public static Boolean doAddCar(Car car){
		return getProxy().AddCar(car);
	}
	
	public static Boolean doUpdateCar(Integer id, String newModel, String newMark){
		return getProxy().UpdateCar(id, newModel, newMark);
	}
	
	public static Boolean doDeleteCar(Integer id){
		return getProxy().DeleteCar(id);
	}
	
	public static List<Car> doFindAllCars(){
		return getProxy().findAllCars();
	}
	
	public static Car doFindCarById(Integer id){
		return getProxy().findCarById(id);
	}
	
	public static List<Car> doFindCarByModel(String model){
		return getProxy().findCarByModel(model);
	}
	
	public static List<Car> doFindCarByMark(String mark){
		return getProxy().findCarByMark(mark);
	}

	public static List<String> doFindAllModelsOfCar(){
		return getProxy().findAllModelsOfCar();
	}
	
	public static List<String> doFindAllMarkOfCar(){
		return getProxy().findAllMarkOfCar();
	}
	
	public static List<Contract> doFindAllContracts(){
		return getProxy().findAllContracts();
	}
	
	public static Contract doFindContractById(ContractId contratId){
		return getProxy().findContractById(contratId);
	}
	public static List<Contract> doFindContractsByCarId(Integer id){
		return getProxy().findContractsByCarId(id);
	}
	
	public static List<Contract> doFindContractsByCarMark(String mark){
		return getProxy().findContractsByCarMark(mark);
	}
	
	public static List<Contract> doFindContractsByCarModel(String model){
		return getProxy().findContractsByCarModel(model);
	}
	
	public static Boolean doAddContract(Contract contract){
		return getProxy().addContract(contract);
	}
	
	public static Boolean doDeleteContract(Integer id){
		return getProxy().deleteContract(id);
	}
	
	public static Boolean doAddClient(Client client){
		return getProxy().addClient(client);
	}
	
	
	
	
}
