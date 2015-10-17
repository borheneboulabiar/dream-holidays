package testFlightServices;

import java.util.List;

import delegate.FlightManagementDelegate;
import entities.Flight;

public class TestFlightServices {

	public static void main(String[] args) {
		List<Flight> flights = FlightManagementDelegate.doFindAllFlights();
		for (Flight f : flights) {
			System.out.println("ahhhh : "+f.getNumberOfPlaces());
		}

	}

}
