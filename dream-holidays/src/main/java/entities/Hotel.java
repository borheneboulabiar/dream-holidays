package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Address address;
	private Integer phoneNumber;
	private Integer NumberofStars;

	private List<Room> rooms;
	
	private List<HotelReservation> reservationsHotel;

	@OneToMany(mappedBy = "hotel")
	@Column(nullable=true)
	public List<HotelReservation> getReservationsHotel() {
		return reservationsHotel;
	}

	public void setReservationsHotel(List<HotelReservation> reservationsHotel) {
		this.reservationsHotel = reservationsHotel;
	}

	@OneToMany(mappedBy = "hotel")
	@Column(nullable=true)
	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Hotel() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getNumberofStars() {
		return NumberofStars;
	}

	public void setNumberofStars(Integer numberofStars) {
		NumberofStars = numberofStars;
	}

}
