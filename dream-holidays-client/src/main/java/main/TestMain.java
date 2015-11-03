package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder.In;

import delegate.FlightManagementDelegate;
import delegate.HotelManagementDelegate;
import entities.Address;
import entities.Flight;
import entities.Hotel;
import entities.Room;

public class TestMain {

	public static void main(String[] args) {

		boolean menu=true;
		while(menu)
		{
			System.out.println("1: Management of Fligths");
			System.out.println("2: Management of Cars");
			System.out.println("3: Management of Hotels");
			System.out.println("0: Quit");
			Scanner scan = new Scanner(System.in);
			
			String choice = scan.nextLine();
			switch (choice){
			case "1":
				boolean sousmenu= true;
				while(sousmenu)
				{
					System.out.println("1.1 : List All Flights");
					System.out.println("1.2 : Search Flights By Date");
					System.out.println("1.3 : Search Flights By Towns");
					System.out.println("1.4 : Add Flight Reservation");
					System.out.println("1.5 : Reset Flight Reservation");
					scan= new Scanner(System.in);
					String choice2 = scan.nextLine();
					List<Flight> flights = null;
					switch(choice2){
					case "1":
					   
						flights = FlightManagementDelegate.doFindAllFlights();
						for (Flight f : flights) {
							System.out.println(f.getId()+" | "+f.getNumberOfPlaces()+" | "+f.getDepartureDate()+" | "+f.getArrivalDate()+" | "+f.getDepartureTown()+" | "+f.getAeroport().getTown());
						}
						System.out.println("You want to continue on the current menu ... ?(yes/no)");
						scan= new Scanner(System.in);
						String choice3 = scan.nextLine();
						switch(choice3){
						case "yes":
							sousmenu=true;
							break;
						case "no":
							sousmenu=false;
							menu = false;
							break;
						}
						break;
					case "2":
						
						scan = new Scanner(System.in);
						System.out.println("Enter the departure date");
						String arrivaldate = scan.nextLine();
						System.out.println("Enter the return date");
						String departuredate = scan.nextLine();
						
						SimpleDateFormat dt =new SimpleDateFormat("dd.MM.yyyy");
						try {
							
							Date arrivalDate=dt.parse(arrivaldate);
							Date departureDate=dt.parse(departuredate);
							
							flights = FlightManagementDelegate.doFindFlightByDate(arrivalDate, departureDate);
							if(flights.isEmpty())
								System.out.println("There is no flights for these dates");
							else
							{
							for (Flight f : flights) {
								System.out.println(f.getId()+" | "+f.getNumberOfPlaces()+" | "+f.getDepartureDate()+" | "+f.getArrivalDate()+" | "+f.getDepartureTown()+" | "+f.getAeroport().getTown());
							}
							}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("You want to continue on the current menu ... ?(yes/no)");
						scan= new Scanner(System.in);
						choice3 = scan.nextLine();
						switch(choice3){
						case "yes":
							sousmenu=true;
							break;
						case "no":
							sousmenu=false;
							menu = false;
							break;
						}
						break;
					case "3":
						scan = new Scanner(System.in);
						System.out.println("Enter the departure town");
						String departureTown = scan.nextLine();
						System.out.println("Enter the destination town1");
						String destinationTown = scan.nextLine(); 
						
						flights = FlightManagementDelegate.doFindFlightsByTowns(departureTown, destinationTown);
						for (Flight f : flights) {
							System.out.println(f.getId()+" | "+f.getNumberOfPlaces()+" | "+f.getDepartureDate()+" | "+f.getArrivalDate()+" | "+f.getDepartureTown()+" | "+f.getAeroport().getTown());
						}
						System.out.println("You want to continue on the current menu ... ?(yes/no)");
						scan= new Scanner(System.in);
						choice3 = scan.nextLine();
						switch(choice3){
						case "yes":
							sousmenu=true;
							break;
						case "no":
							sousmenu=false;
							menu = false;
							break;
						}
						break;
					case "4":
						scan = new Scanner(System.in);
						System.out.println("Enter the client Identifier");
						String clientId = scan.nextLine();
						System.out.println("Enter the flight Identifier");
						String flightId = scan.nextLine(); 
						System.out.println("Enter the seat");
						String seat = scan.nextLine();
						int i,j;
						i = Integer.parseInt(clientId); 
						j = Integer.parseInt(flightId);
						Boolean test=false;
						Boolean test2=false;
						Flight flight = FlightManagementDelegate.doFindFlightById(j);
						//Client client = FlightManagementDelegate.doFindClienById(i);
						if (flight.getNumberOfPlaces()==0)
						{
							System.out.println("There is no more places");
						}
						else
						{
						test = FlightManagementDelegate.doAddFlightReservation(i, j, seat);
						if(test)
						{
							System.out.println("The flight reservation has been added");
							test2 = FlightManagementDelegate.doUpdateFlight(j);
						}
						else
							System.out.println("There is a problem of adding this float reservation");
						}
						System.out.println("You want to continue on the current menu ... ?(yes/no)");
						scan= new Scanner(System.in);
						choice3 = scan.nextLine();
						switch(choice3){
						case "yes":
							sousmenu=true;
							break;
						case "no":
							sousmenu=false;
							menu = false;
							break;
						}
						break;
					case "5":
						scan = new Scanner(System.in);
						System.out.println("Enter the client Identifier");
						String clientId1 = scan.nextLine();
						System.out.println("Enter the flight Identifier");
						String flightId1 = scan.nextLine(); 
						
						int k,l;
						k = Integer.parseInt(clientId1); 
						l = Integer.parseInt(flightId1);
						Boolean test1=false;
						test1 = FlightManagementDelegate.doDeleteReservation(k,l);
						if(test1)
						{
							System.out.println("The flight reservation has been removed");
						}
						else
							System.out.println("There is a problem of deleting this float reservation");
						System.out.println("You want to continue on the current menu ... ?(yes/no)");
						scan= new Scanner(System.in);
						choice3 = scan.nextLine();
						switch(choice3){
						case "yes":
							sousmenu=true;
							break;
						case "no":
							sousmenu=false;
							menu = false;
							break;
						}
						break;
					}

				}
             menu=true;
             break;
			case "3":
				List<Hotel> hotels;
				boolean sousmenu1= true;
				while(sousmenu1)
				{
					System.out.println("1.1 : List All Hotels");
					System.out.println("1.2 : Search Hotels By Stars");
					System.out.println("1.3 : Search Hotels By Country");
					System.out.println("1.4 : Search Hotel By Name");
					System.out.println("1.5 : Show Room Prices");
					System.out.println("1.6 : Booking Of Hotel Room");
					System.out.println("1.7 : Reset Booking");
					scan= new Scanner(System.in);
					String choice2 = scan.nextLine();
					
					switch(choice2){
					case "1":
					   
						hotels = HotelManagementDelegate.dofindAllHotels();
						for (Hotel h : hotels) {
							System.out.println(h.getId()+" | "+h.getName()+" | "+h.getNumberofStars()+" | "+h.getPhoneNumber()+" | "+h.getAddress()+" | ");
						}
						System.out.println("You want to continue on the current menu ... ?(yes/no)");
						scan= new Scanner(System.in);
						String choice3 = scan.nextLine();
						switch(choice3){
						case "yes":
							sousmenu1=true;
							break;
						case "no":
							sousmenu1=false;
							menu = false;
							break;
						}
						break;
					case "2":
						System.out.println("Enter The Number Of Stars");
						String nbStars = scan.nextLine();
						Integer m = Integer.parseInt(nbStars);
						hotels=HotelManagementDelegate.doSearchHotelsByStars(m);
						for (Hotel h : hotels) {
							System.out.println(h.getId()+" | "+h.getName()+" | "+h.getNumberofStars()+" | "+h.getPhoneNumber()+" | "+h.getAddress()+" | ");
						}
						System.out.println("You want to continue on the current menu ... ?(yes/no)");
						scan= new Scanner(System.in);
						choice3 = scan.nextLine();
						switch(choice3){
						case "yes":
							sousmenu1=true;
							break;
						case "no":
							sousmenu1=false;
							menu = false;
							break;
						}
						break;
					case "3":
						System.out.println("Enter The Country");
						String country = scan.nextLine();
						Address address = new Address();
						address.setCountry(country);
						hotels= HotelManagementDelegate.doSearchHotelsByCountry(address);
						
						for (Hotel h : hotels) {
							System.out.println(h.getId()+" | "+h.getName()+" | "+h.getNumberofStars()+" | "+h.getPhoneNumber()+" | "+h.getAddress()+" | ");
						}
						System.out.println("You want to continue on the current menu ... ?(yes/no)");
						scan= new Scanner(System.in);
						choice3 = scan.nextLine();
						switch(choice3){
						case "yes":
							sousmenu1=true;
							break;
						case "no":
							sousmenu1=false;
							menu = false;
							break;
						}break;
					case "4":
						System.out.println("Enter The Hotel Name");
						String name = scan.nextLine();
						
						hotels= HotelManagementDelegate.doSearchHotelByName(name);
						
						for (Hotel h : hotels) {
							System.out.println(h.getId()+" | "+h.getName()+" | "+h.getNumberofStars()+" | "+h.getPhoneNumber()+" | "+h.getAddress()+" | ");
						}
						System.out.println("You want to continue on the current menu ... ?(yes/no)");
						scan= new Scanner(System.in);
						choice3 = scan.nextLine();
						switch(choice3){
						case "yes":
							sousmenu1=true;
							break;
						case "no":
							sousmenu1=false;
							menu = false;
							break;
						}break;
					case "5":
						System.out.println("Enter The Hotel Name");
						String nameHotel = scan.nextLine();
						
						List<Room> rooms = HotelManagementDelegate.doGetPricesRoomForHotel(nameHotel);
						
						for (Room r : rooms) {
							System.out.println(r.getHotelRoomId()+" | "+r.getPrice()+" |");
						}
						System.out.println("You want to continue on the current menu ... ?(yes/no)");
						scan= new Scanner(System.in);
						choice3 = scan.nextLine();
						switch(choice3){
						case "yes":
							sousmenu1=true;
							break;
						case "no":
							sousmenu1=false;
							menu = false;
							break;
						}
						break;
					case "0":
						sousmenu1=false;
						break;
					}

				}
             menu=true;
             break;
				
			case "0":
				System.out.println("Good Bye");
				menu=false;
			}
			
		}
		
		

	}
}