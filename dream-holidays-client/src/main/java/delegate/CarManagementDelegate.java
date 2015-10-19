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
	
	public List<Car> doFindAllCars(){
		return getProxy().findAllCars();
	}
	
	public Boolean doAddCar(Car car){
		return getProxy().AddCar(car);
	}
}
