package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String lastName;
	private String firstName;
	private Address address;
	private String email;
	private String passport;
	private String NIC;
	private Integer phoneNumber;
	
	private List<HotelReservation> reservationsHotel;
	private List<Contract> contracts;
	private List<FlightReservation> reservationsFlight;
	
	
	
	public List<FlightReservation> getReservationsFlight() {
		return reservationsFlight;
	}
	public void setReservationsFlight(List<FlightReservation> reservationsFlight) {
		this.reservationsFlight = reservationsFlight;
	}
	@OneToMany(mappedBy = "client")
	public List<Contract> getContracts() {
		return contracts;
	}
	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
	@OneToMany(mappedBy = "client")
	public List<HotelReservation> getReservationsHotel() {
		return reservationsHotel;
	}
	public void setReservationsHotel(List<HotelReservation> reservationsHotel) {
		this.reservationsHotel = reservationsHotel;
	}

	
	
	public Client() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getNIC() {
		return NIC;
	}

	public void setNIC(String nIC) {
		NIC = nIC;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
}
