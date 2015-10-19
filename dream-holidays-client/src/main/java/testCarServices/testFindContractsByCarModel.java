package testCarServices;

import java.util.List;

import delegate.CarManagementDelegate;
import entities.Contract;

public class testFindContractsByCarModel {

	public static void main(String[] args) {
		List<Contract> contracts = CarManagementDelegate.doFindContractsByCarModel("Polo4");
		for (Contract contract : contracts) {
			System.out.println(contract.getStartDate());
		}

	}

}
