package delegate;

import java.util.List;

import entities.Flight;
import entities.Hotel;
import locator.ServiceLocator;
import services.interfaces.HotelManagementRemote;

public class HotelManagementDelegate {
	
	public static final String jndiName = "/dream-holidays/HotelManagement!services.interfaces.HotelManagementRemote";

	public static HotelManagementRemote getProxy() {
		return (HotelManagementRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}
	
	public static List<Hotel> dofindAllHotels() {
		return getProxy().findAllHotels();
	}
	
	public Hotel SearchHotelById(int id) {
		return getProxy().SearchHotelById(id);
	}
	

}
