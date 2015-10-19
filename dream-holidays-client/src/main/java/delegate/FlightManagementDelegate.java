package delegate;

import java.util.Date;
import java.util.List;

import locator.ServiceLocator;
import services.interfaces.FlightManagementRemote;
import entities.Flight;

public class FlightManagementDelegate {
	public static final String jndiName = "/dream-holidays/FlightManagement!services.interfaces.FlightManagementRemote";

	public static FlightManagementRemote getProxy() {
		return (FlightManagementRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

	public static List<Flight> doFindAllFlights() {
		return getProxy().findAllFlights();
	}
	
	public static Flight doFindFlightById(Integer id) {
		return getProxy().findFlightById(id);
	}
	
	public static List<Flight> doFindFlightByDate(Date ArrivalDate, Date DepartureDate) {
		return getProxy().findFlightByDate(ArrivalDate,DepartureDate);
	}
	
}
