package delegate;

import java.util.List;

import entities.Car;
import entities.Contract;
import locator.ServiceLocator;
import services.interfaces.CarManagementRemote;

public class CarManagementDelegate {

	public static final String jndiName = "/dream-holidays/CarManagement!services.interfaces.CarManagementRemote";
	
	public static CarManagementRemote getProxy(){
		return (CarManagementRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}
	
	public static List<Car> doFindAllCars(){
		return getProxy().findAllCars();
	}
	
	public static Boolean doAddCar(Car car){
		return getProxy().AddCar(car);
	}
	
	public static List<Car> doFindCarByModel(String model){
		return getProxy().findCarByModel(model);
	}
	
	public static List<Car> doFindCarByMark(String mark){
		return getProxy().findCarByMark(mark);
	}
	
	public static Car doFindCarById(Integer id){
		return getProxy().findCarById(id);
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
}
