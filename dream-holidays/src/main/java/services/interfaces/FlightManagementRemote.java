package services.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entities.Flight;

@Remote
public interface FlightManagementRemote {

	List<Flight> findAllFlights();
	Flight findFlightById(Integer id);
	List<Flight> findFlightByDate(Date ArrivalDate,Date DepartureDate);
	
}
