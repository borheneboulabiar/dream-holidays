package testCarServices;

import java.util.List;

import delegate.CarManagementDelegate;
import entities.Contract;

public class testFindContractByCarId {

	public static void main(String[] args) {
		
		List<Contract> contracts = CarManagementDelegate.doFindContractsByCarId(1);
		for (Contract contract : contracts) {
			System.out.println(contract.getStartDate());
		}

	}

}
