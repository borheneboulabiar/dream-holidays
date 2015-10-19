package testFlightServices;

import delegate.FlightManagementDelegate;
import entities.Client;
import entities.Flight;
import entities.FlightReservation;

public class TestAddReservation {

	public static void main(String[] args) {
		Flight flight = FlightManagementDelegate.doFindFlightById(1);
		Client client = FlightManagementDelegate.doFindClienById(1);
		FlightReservation flightReservation = new FlightReservation();
		flightReservation.setFlight(flight);
		flightReservation.setClient(client);
		Boolean reservation = FlightManagementDelegate.doAddFlightReservation(flightReservation);
		System.out.println(reservation);
	}

}
