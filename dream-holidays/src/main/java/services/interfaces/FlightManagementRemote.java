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
	Boolean UpdateFlight(Flight flight);
	List<Flight> findAllFlights();
	Flight findFlightById(Integer id);
	List<Flight> findFlightByDate(Date ArrivalDate,Date DepartureDate);
	List<Flight> findFlightsByTowns(String DepartureTown, String DestinationTown);
	FlightReservation findFlightReservationById(Client c, Flight f);
	Boolean addFlightReservation(FlightReservation flightReservation);
	Boolean DeleteReservation(Client c, Flight f);
	Boolean UpdateReservations(FlightReservation flightReservation);
	Client findClienById(Integer id);
}
