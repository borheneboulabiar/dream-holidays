package services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.Car;
import entities.Client;
import entities.Contract;
import entities.ContractId;
import services.interfaces.CarManagementLocal;
import services.interfaces.CarManagementRemote;

/**
 * Session Bean implementation class CarManagement
 */
@Stateless
public class CarManagement implements CarManagementRemote, CarManagementLocal {
	
	@PersistenceContext
	EntityManager entityManager;
    
	/**
     * Default constructor. 
     */
    public CarManagement() {
        // TODO Auto-generated constructor stub
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> findAllCars() {
			
		return entityManager.createQuery("Select c from Car c").getResultList();
		
	}

	@Override
	public Car findCarById(int id) {
		
		return entityManager.find(Car.class, id);
	}

	@Override
	public Boolean AddCar(Car car) {
		Boolean add = false;
		try{
			entityManager.persist(car);
			add = true;
		}catch(Exception e){
			System.err.println("Problem adding car ...");
		}
		return add;
		
	}
	
	@Override
	public Boolean DeleteCar(Integer id) {
		Boolean delete = false;
		try {
			entityManager.remove(entityManager.merge(entityManager.find(Car.class, id)));
			delete = true;
		} catch (Exception e) {
			System.err.println("Problem deleting ...");
		}
		return delete;
	}

	@Override
	public Boolean UpdateCar(Integer id, String newModel, String newMark) {
		Boolean update = false;
		try {
			Car carFound = entityManager.find(Car.class, id);
			carFound.setMark(newMark);
			carFound.setModel(newModel);
			entityManager.merge(carFound);
			update = true;
		} catch (Exception e) {
			System.err.println("Problem updating ...");
		}
		return update;
	}
	
	@Override
	public List<Car> findCarByModel(String model) {
		Query query = entityManager.createQuery
				("Select c from Car c where c.model =:param")
				.setParameter("param", model);
		
		return query.getResultList();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Car> findCarByMark(String mark) {
		Query query = entityManager.createQuery
				("SELECT c from " + Car.class.getSimpleName() + " c where c.mark = :param")
				.setParameter("param", mark);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> findContractsByCarId(Integer id) {
		Query query = entityManager.createQuery
				("SELECT c FROM Contract c where c.carId = :param")
				.setParameter("param", id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> findContractsByCarMark(String mark) {
		Query query = entityManager.createQuery("SELECT co from Car ca "
				+ " Contract co where ca.id=co.carId and ca.mark = :param ");
		query.setParameter("param", mark);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> findContractsByCarModel(String model) {
		Query query = entityManager.createQuery("SELECT co from Car ca "
				+ " Contracts co where ca.id=co.carId and ca.model = :param ");
		query.setParameter("param", model);
		return query.getResultList();
	}

	@Override
	public Boolean addContract(Contract contract) {
		Boolean add = true;
		try {
			entityManager.persist(contract);
		} catch (Exception e) {
			add = false;
		}
		return add;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> findAllContracts() {
		
		return entityManager.createQuery("SELECT c from Contract c").getResultList();
	}

	@Override
	public Boolean addClient(Client client) {
		Boolean add = true;
		try {
			entityManager.persist(client);
		} catch (Exception e) {
			add = false;
		}
		return add;
	}

	@SuppressWarnings("null")
	@Override
	public List<String> findAllModelsOfCar() {
		List<String> list = new ArrayList<String>();
		list=entityManager.createQuery("Select distinct c.model from Car c").getResultList();
		
		return list; 
	}

	@SuppressWarnings("null")
	@Override
	public List<String> findAllMarkOfCar() {
		List<String> list = new ArrayList<String>();
		list = entityManager.createQuery("select distinct c.mark from Car c").getResultList();
		
		return list;
	}
	
	@Override
	public Boolean deleteContract(Integer id) {
		Boolean delete = false;
		try {
			entityManager.remove(entityManager.merge(entityManager.find(Contract.class, id)));
			delete = true;
		} catch (Exception e) {
			System.err.println("Problem deleting ..");
		}
		return delete;
	}

	@Override
	public Contract findContractById(ContractId contratId) {
		
		return (Contract) entityManager.find(Contract.class, contratId);
	}

}
