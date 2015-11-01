package testFlightServices;

import java.util.Date;
import java.util.List;

import delegate.FlightManagementDelegate;
import entities.Flight;

public class TestFindFlightsByTowns {

	public static void main(String[] args) {
		String departureTown = "Tunis";
		String destinationTown = "Paris";
		List<Flight> flights = FlightManagementDelegate.doFindFlightsByTowns(departureTown, destinationTown);
		for (Flight f : flights) {
			System.out.println(" id of flight: " + f.getId());
		}

	}

}
