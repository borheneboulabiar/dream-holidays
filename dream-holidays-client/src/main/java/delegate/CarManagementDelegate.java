package delegate;

import java.util.List;

import entities.Car;
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
}
