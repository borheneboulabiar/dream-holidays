package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Address;
import entities.Aeroport;
import entities.Car;
import entities.Client;
import entities.Contract;
import entities.Flight;

@Singleton
@LocalBean
@Startup
public class PopulateDB {
	@PersistenceContext
	private EntityManager entityManager;

	public PopulateDB() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@PostConstruct
	public void initDB() {
		
		Aeroport aeroport = new Aeroport();
		aeroport.setTown("Madrid");
		Aeroport aeroport1 = new Aeroport();
		aeroport1.setTown("Paris");
		Aeroport aeroport2 = new Aeroport();
		aeroport2.setTown("Tunis");
		entityManager.persist(aeroport);
		entityManager.persist(aeroport1);
		entityManager.persist(aeroport2);
		
		Address address = new Address();
		address.setCountry("Tunisia");
		address.setStreet("Soliman");
		
		Client client = new Client();
		client.setAddress(address);
		client.setEmail("borhene@gmail.com");
		client.setFirstName("borhene");
		client.setLastName("boulabiar");
		client.setNIC("06489315");
		entityManager.persist(client);
		
		Address address1 = new Address();
		address1.setCountry("Tunisia");
		address1.setStreet("Ariana");
		
		Client client1 = new Client();
		client1.setAddress(address1);
		client1.setEmail("nouha@gmail.com");
		client1.setFirstName("nouha");
		client1.setLastName("ouerheni");
		client1.setNIC("07895562");
		entityManager.persist(client1);
		
		Flight flight = new Flight();
		SimpleDateFormat dt =new SimpleDateFormat("dd.MM.yyyy");
		try {
			Date arrivalDate=dt.parse("11.10.2015");
			Date departureDate=dt.parse("11.11.2015");
			flight.setArrivalDate(arrivalDate);
			flight.setDepartureDate(departureDate);
			flight.setNumberOfPlaces(4);
			flight.setDepartureTown("Tunis");
			flight.setAeroport(aeroport1);
			entityManager.persist(flight);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Flight flight1 = new Flight();
		
		try {
			Date arrivalDate=dt.parse("11.11.2015");
			Date departureDate=dt.parse("11.12.2015");
			flight1.setArrivalDate(arrivalDate);
			flight1.setDepartureDate(departureDate);
			flight1.setNumberOfPlaces(16);
			flight1.setDepartureTown("Paris");
			flight1.setAeroport(aeroport);
			entityManager.persist(flight1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Car car = new Car();
		car.setMark("Volkswagen");
		car.setModel("Golf 5");
		entityManager.persist(car);
		
		Car car1 = new Car();
		car1.setMark("Volkswagen");
		car1.setModel("Polo 5");
		entityManager.persist(car1);
		
		/*
		Address address = new Address();
		address.setCountry("Tunisia");
		address.setStreet("14 rue mexique");
		
		
		Client client = new Client();
		client.setAddress(address);
		client.setEmail("hm@web2code.com");
		client.setFirstName("hwas");
		client.setLastName("majd");
		client.setNIC("09178626");
		
		entityManager.persist(client);
		
		Contract contract = new Contract();
		//contract.setCar(entityManager.find(Car.class, 1));
		contract.setClient(client);
		entityManager.persist(contract);
		*/
		
		
	}

}
