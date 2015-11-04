package testFlightServices;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import services.impl.FlightManagement;
import delegate.CarManagementDelegate;
import delegate.FlightManagementDelegate;
import entities.Client;
import entities.Flight;
import entities.FlightReservation;

public class FlightTest {

	FlightManagementDelegate flighrDelegate;
	
	@Before
	public void setUp() throws Exception {
		
		flighrDelegate=new FlightManagementDelegate();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testdoFindAllFlights() {
		List<Flight> flights=flighrDelegate.doFindAllFlights();
	}
	
	@Test
	public void testdoFindFlightById() {
	  Flight flights=flighrDelegate.doFindFlightById(1);
	}

	@Test
	public void testdoFindClienById() {
	  Client client=flighrDelegate.doFindClienById(1);
	}
	
	@Test
	public void testdoFindFlightByDate() {
		
		try {
			SimpleDateFormat sdf=new SimpleDateFormat();
			List<Flight> flights=flighrDelegate.doFindFlightByDate(sdf.parse("01.09.2015"), sdf.parse("01.10.2015"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testdoFindFlightsByTowns() {
		
		
	  List<Flight> flights=flighrDelegate.doFindFlightsByTowns("Paris", "Madrid");
		
	}
	@Test
	public void testdoFindFlightReservationById() {
		
		
		FlightReservation flights=flighrDelegate.doFindFlightReservationById(1,1);
		
	}
	@Test
	public void testdoDeleteReservation() {
		
		
		flighrDelegate.doDeleteReservation(1,1);
		
	}
	@Test
	public void testdoAddFlightReservation() {
		
		flighrDelegate.doAddFlightReservation(1,1,"a");
		
	}
	@Test
	public void testdoUpdateFlight() {
		
		
	  flighrDelegate.doUpdateFlight(1);
		
	}
}
