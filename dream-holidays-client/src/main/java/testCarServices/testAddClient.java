package testCarServices;

import delegate.CarManagementDelegate;
import entities.Client;

public class testAddClient {

	public static void main(String[] args) {
		
		Client client = new Client();
		client.setEmail("hm@web2code.com");
		client.setFirstName("hwas");
		client.setLastName("majd");
		
		System.out.println(CarManagementDelegate.doAddClient(client));

	}

}
