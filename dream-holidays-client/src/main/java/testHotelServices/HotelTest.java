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
import entities.Room;

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
	
	@Test
	public void testdoGetPricesRoomForHotel() {

		List<Room> rooms=hd.doGetPricesRoomForHotel("Movempick");
	}
	@Test
	public void testdoSearchDetailReservationByHotelClient() {

		Client c=new Client();
		c.setId(1);
		Hotel h=new Hotel();
		h.setId(1);
		HotelReservation hotelReservation=hd.doSearchDetailReservationByHotelClient(c,h);
	}
	@Test
	public void testdoGetReservationsNow() {
		Hotel h=new Hotel();
		h.setId(1);
		List<HotelReservation> hotelReservation=hd.doGetReservationsNow(h);
	}
	@Test
	public void testdoGetHotelsWithRoomPrice() {

		List<Hotel> hotels=hd.doGetHotelsWithRoomPrice(300);
	}
	@Test
	public void testdoGetHotelsWithMaxRoomPrice() {

		List<Hotel> hotels=hd.doGetHotelsWithMaxRoomPrice(300);
	}
}
