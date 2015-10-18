package services.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import entities.Client;
import entities.Hotel;
import entities.HotelReservation;

@Remote
public interface HotelManagementRemote {

	void AddHotel(Hotel h);
	void DeleteHotel(int id);
	void UpdateHotel(int id);
	List<Hotel> findAllHotels();
	Hotel findHotelById(int id);
	List<HotelReservation> getReservationByDate(Date date,Hotel hotel);
	int getNumberOfAvailableRoom(Hotel hotel);
	int getNumberOfAvailableRoomByDate(Date date,Hotel hotel);
	int getNumberOfAvailableRoomByType(String typeOfRoom);
	
	
	
	
}
