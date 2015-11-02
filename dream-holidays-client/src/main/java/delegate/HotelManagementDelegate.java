package delegate;

import java.util.List;

import entities.Address;
import entities.Client;
import entities.Flight;
import entities.Hotel;
import entities.HotelReservation;
import entities.Room;
import locator.ServiceLocator;
import services.interfaces.HotelManagementRemote;

public class HotelManagementDelegate {
	
	public static final String jndiName = "/dream-holidays/HotelManagement!services.interfaces.HotelManagementRemote";

	public static HotelManagementRemote getProxy() {
		return (HotelManagementRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}
	
	public static List<Hotel> dofindAllHotels() {
		return getProxy().findAllHotels();
	}
	
	public static Hotel doFindHotelById(int id) {
		return getProxy().SearchHotelById(id);
	}
	
	public static void doAddHotel(Hotel hotel)
	{
		getProxy().AddHotel(hotel);
	}
	public static List<Hotel> doSearchHotelsByStars(int numberOfStars)
	{
		return getProxy().SearchHotelsByStars(numberOfStars);	
	}
	public static List<Hotel> doSearchHotelsByCountry(Address adr)
	{
		return getProxy().SearchHotelsByCountry(adr);
	}
	
	public static Hotel doSearchHotelByName(String name)
	{
		return getProxy().SearchHotelByName(name);
	}
	public static List<Room> doGetPricesRoomForHotel(String name)
	{
		return getProxy().GetPricesRoomForHotel(name);
	}
	public static HotelReservation doSearchDetailReservationByHotelClient(Client c , Hotel h)
	{
		return getProxy().SearchDetailReservationByHotelClient(c, h);
	}
	public static List<HotelReservation> doGetReservationsNow(Hotel h)
	{
		return getProxy().GetReservationsNow(h);
	}
	
	public static List<Hotel> doGetHotelsWithRoomPrice(float price)
	{
	return  getProxy().getHotelsWithRoomPrice(price);
	}
	public static List<Hotel> doGetHotelsWithMaxRoomPrice(float price)
	{
	return getProxy().getHotelsWithMaxRoomPrice(price);
	}
}
