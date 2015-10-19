package delegate;

import locator.ServiceLocator;
import services.interfaces.HotelManagementRemote;

public class HotelManagementDelegate {
	
	public static final String jndiName = "/dream-holidays/HotelManagement!services.interfaces.HotelManagementRemote";

	public static HotelManagementRemote getProxy() {
		return (HotelManagementRemote) ServiceLocator.getInstance().getProxy(
				jndiName);
	}

}
