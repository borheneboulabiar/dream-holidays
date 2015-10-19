package services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.FlightManagementLocal;
import services.interfaces.FlightManagementRemote;
import entities.Flight;

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

	@Override
	public List<Flight> findFlightByDate(Date ArrivalDate, Date DepartureDate) {
		String jpql = "select f from Flight f where ArrivalDate=:param1 and DepartureDate=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", ArrivalDate);
		query.setParameter("param2", DepartureDate);
		return query.getResultList();
		
	}}
