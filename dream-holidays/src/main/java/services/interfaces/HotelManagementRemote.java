package services.interfaces;

import javax.ejb.Remote;

import entities.Hotel;

@Remote
public interface HotelManagementRemote {

	void addHotel(Hotel h);
	void deleteHotel(int id);
	void UpdateHotel(int id);
	
}
