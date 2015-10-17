package services.impl;

import javax.ejb.Stateless;

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

}
