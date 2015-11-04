package services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.Address;
import entities.Client;
import entities.Flight;
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
	public boolean AddHotel(Hotel h) {
		/*try {
			entityManager.persist(h);
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		boolean add = false;
		try{
			entityManager.persist(h);
			add = true;
		}catch(Exception e){
			System.err.println("Problem adding car ...");
		}
		return add;
		

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
	@SuppressWarnings("unchecked")
	@Override
	public List<Hotel> findAllHotels() {
		String jpql = "select h from Hotel h";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}


	@Override
	public Hotel SearchHotelById(int id) {

		Hotel hotel=null;
		try {
			hotel = entityManager.find(Hotel.class, id);
		} catch (Exception e) {
			return null;
		}
		return hotel;
		
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
	public List<Hotel> SearchHotelByName(String name) {
		List<Hotel> hotel ;

		try {
			TypedQuery<Hotel> query = entityManager.createQuery(
					"SELECT h FROM Hotel h where name like :name", Hotel.class)
					.setParameter("name", "%" + name + "%");

			hotel = query.getResultList();

		} catch (NoResultException e) {
			System.out.println("l'hotel n'existe pas ");
		} catch (NonUniqueResultException e) {
			System.out.println("il y'a plusieurs hotels avec le nom saisie");
		}
		return null;

	}

	@Override
	public List<Room> GetPricesRoomForHotel(String name) {

		List<Room> rooms = null;

		try {
			TypedQuery<Room> query = entityManager
					.createQuery(
							"SELECT r FROM Room r JOIN r.hotel h where h.name like :name",
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
	public List<Hotel> getHotelsWithRoomPrice(int price) {
		Query query = null;

		try {
			query = entityManager.createQuery("SELECT r FROM Room r JOIN r.hotel h where r.price=:price")
					.setParameter("price", price);

			

		} catch (NoResultException e) {
			System.out.println("aucun hotels avec ce prix");
		}

		return query.getResultList();
	}
	@Override
	public List<Hotel> getHotelsWithMaxRoomPrice(int price) {
		String jpql = "select DISTINCT h from Hotel h join h.Room r where r.price<:price";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("price", price);
		
		return query.getResultList();
	}

}
