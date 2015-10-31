package services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Address;
import entities.Client;
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

		entityManager.merge(SearchHotelById(hotel.getId()));
		//entityManager.merge(hotel);

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
	public List<Hotel> SearchHotelsByStars(int numberOfStars) {
		TypedQuery<Hotel> query = entityManager.createQuery(
				"SELECT h FROM Hotel h where NumberofStars=:numberOfSatrs",
				Hotel.class).setParameter("numberOfSatrs", numberOfStars);
		;

		List<Hotel> list = query.getResultList();

		return list;
	}

	@Override
	public List<Hotel> SearchHotelsByCountry(Address adr) {
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
	public void UpdateReservation(Client c, Hotel h) {
		
		entityManager.merge(SearchReservationByHotelClient(c,h));

	}

	@Override
	public void DeleteReservation(Client c, Hotel h) {
	
		entityManager.remove(SearchReservationByHotelClient(c,h));
	}

	@Override
	public HotelReservation SearchReservationByHotelClient(Client c, Hotel h) {
		
		HotelReservation hr = (HotelReservation) entityManager.createQuery(
				"SELECT h FROM HotelReservation h where h.hotelReservationId.clientId=:clientId "
				+ "and h.hotelReservationId.hotelId=:hotelId",
				HotelReservation.class)
				.setParameter("clientId",c.getId().toString())
				.setParameter("hotelId", h.getId().toString());
		
		return hr;
	}

	

	
	
}
