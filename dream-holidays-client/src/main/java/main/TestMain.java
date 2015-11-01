package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import delegate.FlightManagementDelegate;
import entities.Flight;

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
					System.out.println("1.4 : Update Flight");
					System.out.println("1.5 : List All Flights Reservations");
					System.out.println("1.6 : Add Flight Reservation");
					System.out.println("1.7 : Delete Flight Reservation");
					System.out.println("1.8 : Update Flight Reservation");
					System.out.println("1.9 : List All Flights");
					scan= new Scanner(System.in);
					String choice2 = scan.nextLine();
					List<Flight> flights = null;
					switch(choice2){
					case "1":
					   
						flights = FlightManagementDelegate.doFindAllFlights();
						for (Flight f : flights) {
							System.out.println(f.getId()+" | "+f.getNumberOfPlaces());
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
					case "2":
						
						scan = new Scanner(System.in);
						System.out.println("Enter the departure date");
						String departuredate = scan.nextLine();
						System.out.println("Enter the arrival date");
						String arrivaldate = scan.nextLine();
						
						SimpleDateFormat dt =new SimpleDateFormat("dd.MM.yyyy");
						try {
							
							Date arrivalDate=dt.parse(arrivaldate);
							Date departureDate=dt.parse(departuredate);
							
							flights = FlightManagementDelegate.doFindFlightByDate(arrivalDate, departureDate);
							for (Flight f : flights) {
								System.out.println(" id of flight: " + f.getId());
							}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("You want to continue on the current menu ... ?");
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
							System.out.println(" id of flight: " + f.getId());
						}
						System.out.println("You want to continue on the current menu ... ?");
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
					case "0":
						sousmenu=false;
						break;
					}

				}
             menu=true;
             break;
			case "2":
				boolean sousmenu1= true;
				while(sousmenu1)
				{
					System.out.println("1.1 : List All Cars");
					System.out.println("1.2 : Search Cars By ....");
					System.out.println("1.3 : Search Cars By .....");
					
					scan= new Scanner(System.in);
					String choice2 = scan.nextLine();
					
					switch(choice2){
					case "1":
					   
						
						System.out.println("You want to continue on the current menu ... ?");
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
						
						
						System.out.println("You want to continue on the current menu ... ?");
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
						
						
						System.out.println("You want to continue on the current menu ... ?");
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
				System.out.println("0000000000000");
				menu=false;
			}
			
		}
		
		

	}

}