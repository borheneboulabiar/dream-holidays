package testCarServices;

import java.util.List;

import delegate.CarManagementDelegate;
import entities.Contract;

public class testFindContractsByCarMark {

	public static void main(String[] args) {
		List<Contract> contracts = CarManagementDelegate.doFindContractsByCarMark("Volkswagen");
		for (Contract contract : contracts) {
			System.out.println(contract.getStartDate());
		}

	}

}
