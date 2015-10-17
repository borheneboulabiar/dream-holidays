package services.impl;

import javax.ejb.Stateless;

import entities.Hotel;
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
	public void addHotel(Hotel h) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteHotel(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateHotel(int id) {
		// TODO Auto-generated method stub
		
	}

}
