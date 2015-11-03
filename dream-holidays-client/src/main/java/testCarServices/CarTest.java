package testCarServices;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import delegate.CarManagementDelegate;
import delegate.HotelManagementDelegate;
import entities.Address;
import entities.Car;
import entities.Client;
import entities.Contract;
import entities.ContractId;

public class CarTest {

	CarManagementDelegate carDelegate;
	
	
	@Before
	public void setUp() throws Exception {
		carDelegate=new CarManagementDelegate();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testdoFindAllCars() {
		
		List<Car> cars=carDelegate.doFindAllCars();
	}
	@Test
	public void testdoFindCarById() {
		
		
		Car car=carDelegate.doFindCarById(1);
		//System.out.println(car.getMark());
	}
	@Test
	public void testdoFindCarByModel() {
		
		
		List<Car> cars=carDelegate.doFindCarByModel("Golf 5");
		for(int i=0;i<cars.size();i++ )
		{
			//System.out.println(cars.get(i).getModel());
		}
		//System.out.println(cars.size());
		
	}
	@Test
	public void testdoFindCarByMark() {
		
		
		List<Car> cars=carDelegate.doFindCarByMark("Volkswagen");
		for(int i=0;i<cars.size();i++ )
		{
			//System.out.println(cars.get(i).getMark());
		}
		//System.out.println(cars.size());
		
	}
	@Test
	public void testdoFindAllModelsOfCar() {
		
		
		List<String> models=carDelegate.doFindAllModelsOfCar();
		for(int i=0;i<models.size();i++ )
		{
			//System.out.println(models.get(i));
		}
		//System.out.println(cars.size());
		
	}
	@Test
	public void testdoFindAllMarkOfCar() {
		
		
		List<String> models=carDelegate.doFindAllMarkOfCar();
		for(int i=0;i<models.size();i++ )
		{
			System.out.println(models.get(i));
		}
		//System.out.println(cars.size());
		
	}
	@Test
	public void testdoFindAllContracts() {
		
		
		List<Contract> contracts=carDelegate.doFindAllContracts();
		
		
	}
	@Test
	public void testdoFindContractById() {
		
		ContractId cid=new ContractId();
		cid.setCarId(2);
		cid.setClientId(2);
		Contract contract=carDelegate.doFindContractById(cid);
		System.out.println(contract.getClient().getFirstName());
		
	}
	@Test
	public void testdoFindContractsByCarId() {
		
		List<Contract> contracts=carDelegate.doFindContractsByCarId(1);
		//System.out.println(contract.getClient().getFirstName());
		
	}
	@Test
	public void testdoFindContractsByCarMark() {
		
		List<Contract> contracts=carDelegate.doFindContractsByCarMark("Volkswagen");
		//System.out.println(contract.getClient().getFirstName());
		
	}
	@Test
	public void testdoFindContractsByCarModel() {
		
		List<Contract> contracts=carDelegate.doFindContractsByCarModel("Golf 5");
		//System.out.println(contract.getClient().getFirstName());
		
	}
	@Test
	public void testdoAddContract() {
		Address address = new Address();
		address.setCountry("Tunisia");
		address.setStreet("Soliman");
		
		Car car = new Car();
		car.setId(1);
		car.setMark("Volkswagen");
		car.setModel("Golf 5");
		
		Client client = new Client();
		client.setId(1);
		client.setAddress(address);
		client.setEmail("borhene@gmail.com");
		client.setFirstName("borhene");
		client.setLastName("boulabiar");
		client.setNIC("06489315");
		
		ContractId contractid=new ContractId();
		contractid.setCarId(client.getId());
		contractid.setClientId(client.getId());
		Contract contract= new Contract();
		contract.setContractId(contractid);
		contract.setPrice(300.0);
		
		carDelegate.doAddContract(contract);
	}
	@Test
	public void testdoDeleteContract() {
		Address address = new Address();
		address.setCountry("Tunisia");
		address.setStreet("Soliman");
		
		Car car = new Car();
		car.setId(1);
		car.setMark("Volkswagen");
		car.setModel("Golf 5");
		
		Client client = new Client();
		client.setId(1);
		client.setAddress(address);
		client.setEmail("borhene@gmail.com");
		client.setFirstName("borhene");
		client.setLastName("boulabiar");
		client.setNIC("06489315");
		
		ContractId contractid=new ContractId();
		contractid.setCarId(client.getId());
		contractid.setClientId(client.getId());
		Contract contract= new Contract();
		contract.setContractId(contractid);
		contract.setPrice(300.0);
		
		carDelegate.doDeleteCar(car.getId());
	}


}
