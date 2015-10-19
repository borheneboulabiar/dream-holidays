package services.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;



import entities.Client;
import entities.Flight;
import entities.FlightReservation;

@Remote
public interface FlightManagementRemote {

	List<Flight> findAllFlights();
	Flight findFlightById(Integer id);
	List<Flight> findFlightByDate(Date ArrivalDate,Date DepartureDate);
	Boolean addFlightReservation(FlightReservation flight);
	Client findClienById(Integer id);
}
