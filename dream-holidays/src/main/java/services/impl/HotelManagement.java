package services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import entities.Hotel;
import entities.HotelReservation;
import services.interfaces.HotelManagementLocal;
import services.interfaces.HotelManagementRemote;

/**
 * Session Bean implementation class HotelManagement
 */
@Stateless
public class HotelManagement implements HotelManagementRemote, HotelManagementLocal {

    /**
     * Default constructor. 
     */
    public HotelManagement() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void AddHotel(Hotel h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DeleteHotel(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateHotel(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Hotel> findAllHotels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel findHotelById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HotelReservation> getReservationByDate(Date date, Hotel hotel) {
		// TODO Auto-generated method stub
		return null;
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
	public int getNumberOfAvailableRoomByType(String typeOfRoom) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
