package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Flight;

@Remote
public interface FlightManagementRemote {

	List<Flight> findAllFlights();
}
