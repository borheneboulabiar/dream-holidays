package services.interfaces;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import entities.Address;
import entities.Hotel;
import entities.HotelReservation;

@Local
public interface HotelManagementLocal {

	void AddHotel(Hotel h);
	void DeleteHotel(int id);
	void UpdateHotel(Hotel hotel);
	List<Hotel> findAllHotels();
	Hotel SearchHotelById(int id);
	List<Hotel> SearchHotelByStars(int numberOfStars);
	List<Hotel> SearchHotelByCountry(Address adr);
	List<HotelReservation> SearchNotCompletedHotelReservation(Address adr);
	void AddReservation(HotelReservation hr); 
	void DeleteReservation(int id); 
	void UpdateReservation(HotelReservation hr);
	
}
