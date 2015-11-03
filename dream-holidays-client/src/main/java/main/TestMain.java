package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder.In;

import delegate.CarManagementDelegate;
import delegate.FlightManagementDelegate;
import delegate.HotelManagementDelegate;
import entities.Address;
import entities.Car;
import entities.Contract;
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
			case "2":
				boolean sousmenu2= true;
				while(sousmenu2)
				{
					
					System.out.println("1.1 : List All Cars");
					System.out.println("1.2 : Find Car By Id");
					System.out.println("1.3 : List All Cars By Mark");
					System.out.println("1.4 : List All Cars By Model");
					
					System.out.println("1.5 : List All Contracts");
					System.out.println("1.6 : Find Contract By Id");
					System.out.println("1.7 : List All Contracts By Car Mark");
					System.out.println("1.8 : List All Contracts By Car Model");
					scan= new Scanner(System.in);
					String choice2 = scan.nextLine();
					switch(choice2){
					case "1":
					    
						List<Car> cars = CarManagementDelegate.doFindAllCars();
						if(cars.size() > 0){
							for (Car car : cars) {
								System.out.println(car.getId() +
										" | Mark : " + car.getMark()+
									    " | Model : " + car.getModel());
							}
						}
						else{
							System.out.println("No Cars Found :( ");
						}
						System.out.println("You want to continue on the current menu ... ?");
					case "2":
						scan = new Scanner(System.in);
						System.out.println("Tape the id of Car");
						Integer id = scan.nextInt();
						Car carById = CarManagementDelegate.doFindCarById(id);						
						if(null != carById){
							System.out.println(carById.getId() +
										" | Mark : " + carById.getMark()+
									    " | Model : " + carById.getModel());							
						}
						else{
							System.out.println("Car Not Found :( ");
						}
						System.out.println("You want to continue on the current menu ... ?");

					case "3":
						System.out.println("Choose Mark to Find All Related Cars");
						List<String> marks = CarManagementDelegate.doFindAllMarkOfCar();						
						for (String mark : marks) {
							System.out.println(mark.toString());
						}
						scan = new Scanner(System.in);
						String mark = scan.nextLine() ;
						List<Car> carsByMark = CarManagementDelegate.doFindCarByMark(mark);
						if(carsByMark.size() > 0){
							for (Car car : carsByMark) {
								System.out.println(car.getId() +
										" | Mark : " + car.getMark()+
									    " | Model : " + car.getModel());
							}
						}
						else{
							System.out.println("No Cars Found :( ");
						}
						System.out.println("You want to continue on the current menu ... ?");

					case "4":
						
						System.out.println("Choose Model to Find All Related Cars");
						List<String> models = CarManagementDelegate.doFindAllModelsOfCar();						
						for (String model : models) {
							System.out.println(model.toString());
						}
						scan = new Scanner(System.in);
						String model = scan.nextLine() ;
						List<Car> carsByModel = CarManagementDelegate.doFindCarByModel(model);
						if(carsByModel.size() > 0){
							for (Car car : carsByModel) {
								System.out.println(car.getId() +
										" | Mark : " + car.getMark()+
									    " | Model : " + car.getModel());
							}
						}
						else{
							System.out.println("No Cars Found :( ");
						}
						System.out.println("You want to continue on the current menu ... ?");

					case "5":
						List<Contract> contracts = CarManagementDelegate.doFindAllContracts();
						if(contracts.size() > 0){
							for (Contract contract : contracts) {
								System.out.println(contract.getContractId().getCarId()+"_"+contract.getContractId().getCarId() +
										" | Client : " + contract.getClient().getLastName()+"_"+contract.getClient().getFirstName()+
									    " | Start Date : " + contract.getStartDate().toString()+
									    " | End Date : " + contract.getEndDate().toString()+
									    " | Price : " + contract.getPrice());
							}
						}
						else{
							System.out.println("No Cars Found :( ");
						}
						System.out.println("You want to continue on the current menu ... ?");

					
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
						if(hotels.isEmpty())
							System.out.println("There is no hotels for this number of stars");
						else
							{for (Hotel h : hotels) {
							System.out.println(h.getId()+" | "+h.getName()+" | "+h.getNumberofStars()+" | "+h.getPhoneNumber()+" | "+h.getAddress()+" | ");
						}}
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
					//Add hotel reservation
					case "6":
						scan = new Scanner(System.in);
						System.out.println("Enter the client Identifier");
						String clientId = scan.nextLine();
						System.out.println("Enter the Hotel Identifier");
						String hotelId = scan.nextLine(); 
						
						int i,j;
						i = Integer.parseInt(clientId); 
						j = Integer.parseInt(hotelId);
						Boolean test=false;
						
						
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
					//Delete hotel reservation
					case "7":
						scan = new Scanner(System.in);
						System.out.println("Enter the client Identifier");
						String clientId1 = scan.nextLine();
						System.out.println("Enter the Hotel Identifier");
						String hotelId1 = scan.nextLine(); 
						
						int k,l;
						k = Integer.parseInt(clientId1); 
						l = Integer.parseInt(hotelId1);
						Boolean test1=false;
						
						
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