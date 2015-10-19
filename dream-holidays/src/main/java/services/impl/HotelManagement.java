package services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Address;
import entities.Hotel;
import entities.HotelReservation;
import services.interfaces.HotelManagementLocal;
import services.interfaces.HotelManagementRemote;

/**
 * Session Bean implementation class HotelManagement
 */
@Stateless
public class HotelManagement implements HotelManagementRemote,
		HotelManagementLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public HotelManagement() {
		// TODO Auto-generated constructor stub
	}

	// Ajout d'un Hotel
	@Override
	public void AddHotel(Hotel h) {

		entityManager.persist(h);

	}

	// Supprimer d'un hotel
	@Override
	public void DeleteHotel(int id) {
		entityManager.remove(SearchHotelById(id));

	}

	@Override
	public void UpdateHotel(Hotel hotel) {

		entityManager.remove(SearchHotelById(hotel.getId()));
		entityManager.merge(hotel);

	}

	@Override
	public List<Hotel> findAllHotels() {

		TypedQuery<Hotel> query = entityManager.createQuery(
				"SELECT h FROM Hotel h", Hotel.class);

		List<Hotel> list = query.getResultList();

		return list;

	}

	@Override
	public Hotel SearchHotelById(int id) {

		return entityManager.find(Hotel.class, id);
	}

	@Override
	public List<Hotel> SearchHotelByStars(int numberOfStars) {
		TypedQuery<Hotel> query = entityManager.createQuery(
				"SELECT h FROM Hotel h where NumberofStars=:numberOfSatrs",
				Hotel.class).setParameter("numberOfSatrs", numberOfStars);
		;

		List<Hotel> list = query.getResultList();

		return list;
	}

	@Override
	public List<Hotel> SearchHotelByCountry(Address adr) {
		TypedQuery<Hotel> query = entityManager.createQuery(
				"SELECT h FROM Hotel h where country=:country",
				Hotel.class).setParameter("country", adr.getCountry());
		;

		List<Hotel> list = query.getResultList();

		return list;
	}

	@Override
	public void AddReservation(HotelReservation hr) {

		entityManager.persist(hr);

	}

	@Override
	public void UpdateReservation(HotelReservation hr) {
		// entityManager.remove(SearchHotelById(hr.g));
		entityManager.merge(hr);

	}

	@Override
	public void DeleteReservation(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<HotelReservation> SearchNotCompletedHotelReservation(Address adr) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
