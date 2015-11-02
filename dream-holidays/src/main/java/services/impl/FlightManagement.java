package services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.FlightManagementLocal;
import services.interfaces.FlightManagementRemote;
import entities.Client;
import entities.Flight;
import entities.FlightReservation;
import entities.FlightReservationId;

/**
 * Session Bean implementation class FlightManagement
 */
@Stateless
public class FlightManagement implements FlightManagementRemote,
		FlightManagementLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public FlightManagement() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> findAllFlights() {
		String jpql = "select f from Flight f";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Flight findFlightById(Integer id) {
		Flight flight = null;
		try {
			flight = entityManager.find(Flight.class, id);
		} catch (Exception e) {
			return null;
		}
		return flight;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> findFlightByDate(Date ArrivalDate, Date DepartureDate) {
		String jpql = "select f from Flight f where ArrivalDate=:param1 and DepartureDate=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", ArrivalDate);
		query.setParameter("param2", DepartureDate);
		return query.getResultList();

	}

	@Override
	public Boolean addFlightReservation(Integer flightId, Integer clientId, String seat) {
		Boolean b = false;
		try {
			
			FlightReservationId flightReservationId = new FlightReservationId();
			flightReservationId.setClientId(clientId);
			flightReservationId.setFlightId(flightId);
			FlightReservation flightReservation = new FlightReservation(flightReservationId,seat);
			entityManager.persist(flightReservation);
			
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Client findClienById(Integer id) {
		Client client = null;
		try {
			client = entityManager.find(Client.class, id);
		} catch (Exception e) {
			return null;
		}
		return client;
	}

	@Override
	public Boolean AddFlight(Flight flight) {
		
		Boolean b = false;
		try {
			entityManager.persist(flight);
			b = true;
		} catch (Exception e) {
			System.err.println("problem ...");
		}
		return b;
		
	}

	@Override
	public Boolean DeleteFlight(int id) {
		Boolean b = false;
		try {
			entityManager.remove(findFlightById(id));
			b = true;
		} catch (Exception e) {
			System.err.println("problem ...");
		}
		return b;
		
		
	}

	@Override
	public Boolean UpdateFlight(Flight flight) {
		Boolean b = false;
		try {
			entityManager.merge(findFlightById(flight.getId()));
			b = true;
		} catch (Exception e) {
			System.err.println("problem ...");
		}
		return b;
		
		
	}

	@Override
	public Boolean DeleteReservation(Client c, Flight f) {
		Boolean b = false;
		try {
			entityManager.remove(findFlightReservationById(c,f));
			b = true;
		} catch (Exception e) {
			System.err.println("problem ...");
		}
		return b;
	}

	@Override
	public Boolean UpdateReservations(FlightReservation flightReservation) {
		Boolean b = false;
		try {
			entityManager.merge(flightReservation);
			b = true;
		} catch (Exception e) {
			System.err.println("problem ...");
		}
		return b;
	}

	@Override
	public FlightReservation findFlightReservationById(Client c, Flight f) {
		FlightReservation flightReservation = null;
		try {
			flightReservation = (FlightReservation) entityManager.createQuery(
					"SELECT f FROM FlightReservation f where f.flightReservationId.clientId=:clientId "
					+ "and f.flightReservationId.flightId=:flightId",
					FlightReservation.class)
					.setParameter("clientId",c.getId().toString())
					.setParameter("flightId", f.getId().toString());
		} catch (Exception e) {
			System.err.println("problem ...");
		}
		return flightReservation;
		
	}

	@Override
	public List<Flight> findFlightsByTowns(String DepartureTown,
			String DestinationTown) {
		//String jpql1 = "select f from Flight f where departureTown=:param1 and DepartureDate=:param2";
		//Query query1 = entityManager.createQuery(jpql1);
		//query1.setParameter("param1", ArrivalDate);
		//query1.setParameter("param2", DepartureDate);
		//query1.getResultList();
		String jpql = "select f from Flight f join f.aeroport a where f.departureTown=:param1 and a.town=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", DepartureTown);
		query.setParameter("param2", DestinationTown);
		return query.getResultList();
	}

}
