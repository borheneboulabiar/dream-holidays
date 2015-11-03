package services.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;




import entities.Client;
import entities.Flight;
import entities.FlightReservation;
import entities.Hotel;

@Remote
public interface FlightManagementRemote {
	
	Boolean AddFlight(Flight flight);
	Boolean DeleteFlight(int id);
	Boolean UpdateFlight(Integer flightId);
	List<Flight> findAllFlights();
	Flight findFlightById(Integer id);
	List<Flight> findFlightByDate(Date ArrivalDate,Date DepartureDate);
	List<Flight> findFlightsByTowns(String DepartureTown, String DestinationTown);
	FlightReservation findFlightReservationById(Integer clientId, Integer flightId);
	Boolean addFlightReservation(Integer flightId, Integer clientId, String seat);
	Boolean DeleteReservation(Integer clientId, Integer flightId);
	Boolean UpdateReservations(FlightReservation flightReservation);
	Client findClienById(Integer id);
}
