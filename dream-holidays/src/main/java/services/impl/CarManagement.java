package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Car;
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
			
		return entityManager.createQuery("Select c from" + Car.class.getSimpleName() +"c").getResultList();
		
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
		entityManager.createQuery("Select c from"+ Car.class.getSimpleName()+"c where c.Model = :param");
		entityManager.setProperty(param, model);
		return 
	}

	@Override
	public List<Car> findCarByMark(String mark) {
		// TODO Auto-generated method stub
		return null;
	}

}
