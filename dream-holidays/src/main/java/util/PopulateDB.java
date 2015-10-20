package util;

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
		aeroport2.setTown("Rome");
		entityManager.persist(aeroport);
		entityManager.persist(aeroport1);
		entityManager.persist(aeroport2);
		
		Flight flight = new Flight();
		flight.setArrivalDate(new Date(115,10,15));
		flight.setDepartureDate(new Date(115, 11, 10));
		flight.setNumberOfPlaces(4);
		flight.setAeroport(aeroport);
		entityManager.persist(flight);
		
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
