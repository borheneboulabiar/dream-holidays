package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.Car;
import entities.Contract;
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
		Boolean add = true;
		try{
			entityManager.persist(car);
		}catch(Exception e){
			add = false;
		}
		return add;
		
	}

	@Override
	public List<Car> findCarByModel(String model) {
		TypedQuery<Car> query = entityManager.createQuery
				("Select c from Car c where c.Model =:param",Car.class)
				.setParameter("param", model);
		
		return query.getResultList();
		
	}

	@Override
	public List<Car> findCarByMark(String mark) {
		TypedQuery<Car> query = entityManager.createQuery
				("SELECT c from "+Car.class.getSimpleName()+" c where c.Mark = :param",Car.class)
				.setParameter("param", mark);
		return query.getResultList();
	}

	@Override
	public List<Contract> findContractsByCarId(Integer id) {
		TypedQuery<Contract> query = entityManager.createQuery
				("SELECT c FROM Contract where c.car = :param",Contract.class)
				.setParameter("param", id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> findContractsByCarMark(String mark) {
		Query query = entityManager.createQuery("SELECT co from Car ca JOIN ca.contracts where ca.mark = :param ");
		query.setParameter("param", mark);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> findContractsByCarModel(String model) {
		Query query = entityManager.createQuery("SELECT co from Car ca JOIN ca.contracts where ca.model = :param ");
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

}
