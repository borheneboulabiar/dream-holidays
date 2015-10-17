package services.impl;

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

}
