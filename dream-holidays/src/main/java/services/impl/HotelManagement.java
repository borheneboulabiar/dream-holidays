package services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Address;
import entities.Client;
import entities.Hotel;
import entities.HotelReservation;
import entities.HotelReservationId;
import entities.Room;
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
		// entityManager.merge(hotel);

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
				"SELECT h FROM Hotel h where country like :country",
				Hotel.class).setParameter("country",
				"%" + adr.getCountry() + "%");
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

		entityManager.merge(SearchDetailReservationByHotelClient(c, h));

	}

	@Override
	public void DeleteReservation(Client c, Hotel h) {

		entityManager.remove(SearchDetailReservationByHotelClient(c, h));
	}

	@Override
	public HotelReservation SearchDetailReservationByHotelClient(Client c,
			Hotel h) {

		HotelReservation hr=new HotelReservation();
		HotelReservationId hri=new HotelReservationId();
		hri.setClientId(c.getId());
		hri.setHotelId(h.getId());
		hr.setHotelReservationId(hri);
		
		return  entityManager.find(HotelReservation.class, hr.getHotelReservationId());
	}

	@Override
	public Hotel SearchHotelByName(String name) {
		Hotel hotel = null;

		try {
			TypedQuery<Hotel> query = entityManager.createQuery(
					"SELECT h FROM Hotel h where name like :name", Hotel.class)
					.setParameter("name", "%" + name + "%");

			hotel = query.getSingleResult();

		} catch (NoResultException e) {
			System.out.println("l'hotel n'existe pas ");
		} catch (NonUniqueResultException e) {
			System.out.println("il y'a plusieurs hotels avec le nom saisie");
		}
		return hotel;

	}

	@Override
	public List<Room> GetPricesRoomForHotel(String name) {

		List<Room> rooms = null;

		try {
			TypedQuery<Room> query = entityManager
					.createQuery(
							"SELECT r FROM Room r, Hotel h where h.id=r.hotelid and h.name like :name",
							Room.class).setParameter("name", "%" + name + "%");

			rooms = query.getResultList();

		} catch (NoResultException e) {
			System.out.println("l'hotel n'existe pas ");
		}

		return rooms;
	}

	@Override
	public List<HotelReservation> GetReservationsNow(Hotel h) {
		List<HotelReservation> hotelsReservation = null;

		try {
			TypedQuery<HotelReservation> query = entityManager
					.createQuery(
							"SELECT hr FROM HotelReservation hr where hr.hotelid=:hotelid and hr.arrivalDate =:sysdate",
							HotelReservation.class)
					.setParameter("hotelid", h.getId())
					.setParameter("sysdate", new Date());

			hotelsReservation = query.getResultList();

		} catch (NoResultException e) {
			System.out.println("aucune réservation faite aujourd'hui");
		}

		return hotelsReservation;
	}

	@Override
	public List<Hotel> getHotelsWithRoomPrice(float price) {
		List<Hotel> hotels = null;

		try {
			TypedQuery<Hotel> query = entityManager
					.createQuery(
							"SELECT h FROM Hotel h,Room r where h.id=r.hotelid and r.price=:price",
							Hotel.class)
					.setParameter("price", price);

			hotels = query.getResultList();

		} catch (NoResultException e) {
			System.out.println("aucun hotels avec ce prix");
		}

		return hotels;
	}
	@Override
	public List<Hotel> getHotelsWithMaxRoomPrice(float price) {
		List<Hotel> hotels = null;

		try {
			TypedQuery<Hotel> query = entityManager
					.createQuery(
							"SELECT DISTINCT h FROM Hotel h,Room r where h.id=r.hotelid and r.price<:price",
							Hotel.class)
					.setParameter("price", price);

			hotels = query.getResultList();

		} catch (NoResultException e) {
			System.out.println("aucun hotels avec ce prix");
		}

		return hotels;
	}

}
