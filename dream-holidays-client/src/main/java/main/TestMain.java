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
					System.out.println("1.2 : Add Flight");
					System.out.println("1.3 : Delete Flight");
					System.out.println("1.4 : Update Flight");
					System.out.println("1.5 : List All Flights Reservations");
					System.out.println("1.6 : Add Flight Reservation");
					System.out.println("1.7 : Delete Flight Reservation");
					System.out.println("1.8 : Update Flight Reservation");
					System.out.println("1.9 : List All Flights");
					Scanner scan1= new Scanner(System.in);
					String choice1 = scan1.nextLine();
					switch(choice1){
					case "1":
					   
						List<Flight> flights = FlightManagementDelegate.doFindAllFlights();
						for (Flight f : flights) {
							System.out.println(f.getId()+" | "+f.getNumberOfPlaces());
						}
						sousmenu=true;
						break;
					case "9":
						
						Scanner scan2 = new Scanner(System.in);
						System.out.println("Saisie la date de départ");
						String departuredate = scan2.nextLine();
						System.out.println("Saisie la date d'arrivée");
						String arrivaldate = scan2.nextLine();
						
						SimpleDateFormat dt =new SimpleDateFormat("dd.MM.yyyy");
						try {
							//Date arrivalDate=dt.parse("11.10.2015");
							Date arrivalDate=dt.parse(arrivaldate);
							//Date departureDate=dt.parse("11.11.2015");
							Date departureDate=dt.parse(departuredate);
							List<Flight> flights1 = FlightManagementDelegate.doFindFlightByDate(arrivalDate, departureDate);
							for (Flight f : flights1) {
								System.out.println(" id of flight: " + f.getId());
							}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						sousmenu=true;
						break;
					case "0":
						sousmenu=false;
						break;
					}
					
					
				}
             menu=true;
             break;
			case "2":
				System.out.println("zdazdazda");
				menu=true;
				break;
				
			case "0":
				System.out.println("0000000000000");
				menu=false;
			}
			
		}
		
		

	}

}