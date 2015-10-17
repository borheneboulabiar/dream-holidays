package services.impl;

import javax.ejb.Stateless;
import services.interfaces.CarManagementLocal;
import services.interfaces.CarManagementRemote;

/**
 * Session Bean implementation class CarManagement
 */
@Stateless
public class CarManagement implements CarManagementRemote, CarManagementLocal {

    /**
     * Default constructor. 
     */
    public CarManagement() {
        // TODO Auto-generated constructor stub
    }

}
