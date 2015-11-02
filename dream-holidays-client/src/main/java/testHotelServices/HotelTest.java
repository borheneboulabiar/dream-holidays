package testHotelServices;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import delegate.HotelManagementDelegate;
import entities.Address;
import entities.Hotel;

public class HotelTest {

	HotelManagementDelegate hd;
	

	@Before
	public void setUp() throws Exception {
		
		hd=new HotelManagementDelegate();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testaddHotel() {
		
		Address a=new Address();
		a.setCountry("Tunisia");
		a.setStreet("Gamarth");
		Hotel h =new Hotel();
		h.setName("Hotel Palace");
		h.setNumberofStars(5);
		h.setPhoneNumber(71987456);
		h.setAddress(a);
		HotelManagementDelegate.doAddHotel(h);
	}

}
