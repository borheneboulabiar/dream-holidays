package services.impl;

import javax.ejb.Stateless;
import services.interfaces.FlightManagementLocal;
import services.interfaces.FlightManagementRemote;

/**
 * Session Bean implementation class FlightManagement
 */
@Stateless
public class FlightManagement implements FlightManagementRemote, FlightManagementLocal {

    /**
     * Default constructor. 
     */
    public FlightManagement() {
        // TODO Auto-generated constructor stub
    }

}
