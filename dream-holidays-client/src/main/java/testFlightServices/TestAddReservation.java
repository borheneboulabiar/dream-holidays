package testFlightServices;

import delegate.FlightManagementDelegate;
import entities.Client;
import entities.Flight;
import entities.FlightReservation;

public class TestAddReservation {

	public static void main(String[] args) {
		
		Boolean reservation = FlightManagementDelegate.doAddFlightReservation(1,1,"A3");
		System.out.println(reservation);
	}

}
