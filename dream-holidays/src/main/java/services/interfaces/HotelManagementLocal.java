package services.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entities.Hotel;
import entities.HotelReservation;

@Local
public interface HotelManagementLocal {

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
