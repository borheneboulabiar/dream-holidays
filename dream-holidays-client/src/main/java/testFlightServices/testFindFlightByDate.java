package testFlightServices;

import java.util.Date;
import java.util.List;

import delegate.FlightManagementDelegate;
import entities.Flight;

public class testFindFlightByDate {

	public static void main(String[] args) {
		List<Flight> flights = FlightManagementDelegate.doFindFlightByDate(
				new Date(115, 10, 15), new Date(115, 11, 10));
		for (Flight f : flights) {
			System.out.println(" id of flight: " + f.getId());
		}

	}

}
