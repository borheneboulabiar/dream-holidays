package services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import entities.Hotel;
import entities.HotelReservation;
import services.interfaces.HotelManagementLocal;
import services.interfaces.HotelManagementRemote;

/**
 * Session Bean implementation class HotelManagement
 */
@Stateless
public class HotelManagement implements HotelManagementRemote, HotelManagementLocal {

	@PersistenceContext
	private EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public HotelManagement() {
        // TODO Auto-generated constructor stub
    }

    //Ajout d'un Hotel
	@Override
	public void AddHotel(Hotel h) {
		
		entityManager.persist(h);
		
	}

	//Supprimer d'un hotel
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
		
     TypedQuery<Hotel> query=entityManager.createQuery("SELECT h FROM Hotel h",Hotel.class);
		
	 List<Hotel> list=query.getResultList();
		
		return list;
		
	}

	@Override
	public Hotel SearchHotelById(int id) {
		
		return entityManager.find(Hotel.class, id);
	}

	@Override
	public List<HotelReservation> getReservationByDate(Date date, Hotel hotel) {
		// TODO Auto-generated method stub
         TypedQuery<HotelReservation> query=entityManager.createQuery
        		 ("SELECT r FROM HotelReservation r,Hotel h where r.hotelId=:hotelId and r.arrivalDate=:arrivalDate",HotelReservation.class)
        		 .setParameter("hotelId", hotel.getId())
        		 .setParameter("arrivalDate", date);
		
		List<HotelReservation> list=query.getResultList();
		
		return list;
	}

	@Override
	public int getNumberOfAvailableRoom(Hotel hotel) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfAvailableRoomByDate(Date date, Hotel hotel) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfAvailableRoomByType(Date date, Hotel hotel,String typeOfRoom) {
		/*TypedQuery<HotelReservation> query=entityManager.createQuery
       		 ("SELECT r FROM HotelReservation r where r.typeOfRoom=:typeOfRoom and r.arrivalDate=:arrivalDate",HotelReservation.class)
       		 .setParameter("typeOfRoom", typeOfRoom)
       		 .setParameter("arrivalDate", date);
		
		List<HotelReservation> list=query.getResultList();*/
		
		
		return 0;
	}

	@Override
	public void AddReservation(HotelReservation hr) {
		
		entityManager.persist(hr);
		
	}

	@Override
	public void DeleteReservation(int id) {
		entityManager.remove(SearchHotelReservationById(id));
		
	}

	@Override
	public void UpdateReservation(HotelReservation hr) {
		//entityManager.remove(SearchHotelById(hr.g));
		entityManager.merge(hr);
		
	}

	@Override
	public HotelReservation SearchHotelReservationById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(HotelReservation.class, id);
	}


	


	

}
