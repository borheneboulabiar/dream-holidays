package testHotelServices;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import delegate.HotelManagementDelegate;
import entities.Address;
import entities.Client;
import entities.Hotel;
import entities.HotelReservation;

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
	public void testfindAllHotels() {
		
		List<Hotel> listh=hd.dofindAllHotels();
		
	}
	@Test
	public void testAddHotel() {

		Client c=new Client();
		c.setId(1);
		Hotel h=new Hotel();
		//h.setId(2);
		HotelReservation hr=new HotelReservation();
		hr.setHotel(h);
		List<HotelReservation> lhr=new ArrayList<>();
		lhr.add(hr);
		h.setReservationsHotel(lhr);
		h.setName("aaaaaaaaaaaaaa");
		hd.doAddHotel(h);
	}
	@Test
	public void testFindHotelById() {

		
		Hotel h=new Hotel();
		h.setId(1);
		h.setName("aaaaaaaaaaaaaa");
		hd.doFindHotelById(h.getId());
	}
	@Test
	public void testFindHotelByStars() {

		
		Hotel h=new Hotel();
		h.setId(1);
		h.setNumberofStars(5);
		
		hd.doFindHotelById(h.getNumberofStars());
	}
	@Test
	public void testFindHotelByName() {

		Hotel h=new Hotel();
		h.setId(1);
		//h.setNumberofStars(5);
		h.setName("aaaaaaaaaaaaaa");
		hd.doSearchHotelByName(h.getName());
	}
}
