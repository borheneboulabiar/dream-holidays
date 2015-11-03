package testHotelServices;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import delegate.CarManagementDelegate;
import delegate.FlightManagementDelegate;
import delegate.HotelManagementDelegate;
import entities.Address;
import entities.Car;
import entities.Flight;
import entities.Hotel;

public class TestAddHotel {

	public static void main(String[] args) {
		
		try {
			
			List<Hotel> hotel=HotelManagementDelegate.doSearchHotelByName("z");
			System.out.println(hotel.get(1).getId());
			System.out.println("aaaaaaaaaa");
		} catch (NoResultException e) {
			System.out.println("l'hotel n'existe pas ");
		} catch (NonUniqueResultException e) {
			System.out.println("il y'a plusieurs hotels avec le nom saisie");
		} catch(NullPointerException e)
		{
			System.out.println("nulll");
		}
		
		//System.out.println(hotel.getId());
		//CarManagementDelegate.getProxy().AddCar(car);

	}

}
