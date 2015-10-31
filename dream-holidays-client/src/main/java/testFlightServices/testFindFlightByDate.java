package testFlightServices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import delegate.FlightManagementDelegate;
import entities.Flight;

public class testFindFlightByDate {

	public static void main(String[] args) {
		SimpleDateFormat dt =new SimpleDateFormat("dd.mm.yyyy");
		try {
			Date arrivalDate=dt.parse("11.10.2015");
			Date departureDate=dt.parse("11.11.2015");
			List<Flight> flights = FlightManagementDelegate.doFindFlightByDate(arrivalDate, departureDate);
			for (Flight f : flights) {
				System.out.println(" id of flight: " + f.getId());
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
