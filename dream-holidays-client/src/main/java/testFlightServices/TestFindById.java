package testFlightServices;

import delegate.FlightManagementDelegate;
import entities.Flight;

public class TestFindById {

	public static void main(String[] args) {
		Flight flight = FlightManagementDelegate.doFindFlightById(1);
		System.out.println(flight.getNumberOfPlaces());	
	}

}
