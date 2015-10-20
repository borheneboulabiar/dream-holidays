package testCarServices;

import java.util.List;

import delegate.CarManagementDelegate;
import entities.Contract;

public class testFindAllContracts {

	public static void main(String[] args) {
		List<Contract> contracts= CarManagementDelegate.doFindAllContracts();
		for (Contract contract : contracts) {
			System.out.println(contract);
		}

	}

}
