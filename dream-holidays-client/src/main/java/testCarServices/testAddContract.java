package testCarServices;

import delegate.CarManagementDelegate;
import entities.Contract;

public class testAddContract {

	public static void main(String[] args) {
		
		Contract contract = new Contract();
		contract.setPrice(200.0);
		contract.setCar(CarManagementDelegate.doFindCarById(1));
		CarManagementDelegate.doAddContract(contract);

	}

}
