package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Address;
import entities.Client;
import entities.Hotel;
import entities.HotelReservation;
import entities.Room;

@Local
public interface HotelManagementLocal {

	boolean AddHotel(Hotel h);
	void DeleteHotel(int id);
	void UpdateHotel(Hotel hotel);
	List<Hotel> findAllHotels();
	Hotel SearchHotelById(int id);
	List<Hotel> SearchHotelsByStars(int numberOfStars);
	List<Hotel> SearchHotelsByCountry(Address adr);
	List<Hotel> SearchHotelByName(String name);
	List<Room> GetPricesRoomForHotel(String name);
	
	void AddReservation(HotelReservation hr); 
	void DeleteReservation(Client c, Hotel h); 
	void UpdateReservation(Client c, Hotel h);
	HotelReservation SearchDetailReservationByHotelClient(Client c , Hotel h);
	List<HotelReservation> GetReservationsNow(Hotel h);
	
	List<Hotel> getHotelsWithRoomPrice(int price);
	List<Hotel> getHotelsWithMaxRoomPrice(int price);
	
}
