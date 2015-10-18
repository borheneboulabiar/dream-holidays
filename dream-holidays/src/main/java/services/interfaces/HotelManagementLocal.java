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
	List<Hotel> findAllHotels();
	Hotel SearchHotelById(int id);
	int getNumberOfAvailableRoom(Hotel hotel);
	int getNumberOfAvailableRoomByDate(Date date,Hotel hotel);
	int getNumberOfAvailableRoomByType(Date date, Hotel hotel,String typeOfRoom);
	
	
	void UpdateHotel(Hotel hotel);
	void AddReservation(HotelReservation hr); 
	void DeleteReservation(int id); 
	void UpdateReservation(HotelReservation hr);
	HotelReservation SearchHotelReservationById(int id);
	List<HotelReservation> getReservationByDate(Date date,Hotel hotel);
}
