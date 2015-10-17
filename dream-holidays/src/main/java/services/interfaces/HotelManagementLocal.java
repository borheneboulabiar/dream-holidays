package services.interfaces;

import javax.ejb.Local;

import entities.Hotel;

@Local
public interface HotelManagementLocal {

	void addHotel(Hotel h);
	void deleteHotel(int id);
	void UpdateHotel(int id);
}
