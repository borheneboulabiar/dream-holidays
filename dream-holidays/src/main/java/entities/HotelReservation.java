package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class HotelReservation implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private HotelReservationId hotelReservationId;
private String state;
private Date departureDate;
private Date arrivalDate;
private Integer numberOfBed;
private String typeOfRoom;

private Client client;
private Hotel hotel;


@ManyToOne
@JoinColumn(name = "clientId", referencedColumnName = "id", updatable = false, insertable = false)
public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}
@ManyToOne
@JoinColumn(name = "hotelId", referencedColumnName = "id", updatable = false, insertable = false)
public Hotel getHotel() {
	return hotel;
}

public void setHotel(Hotel hotel) {
	this.hotel = hotel;
}

public HotelReservation() {
	super();
}

public HotelReservation(HotelReservationId hotelReservationId, String state,
		Date departureDate, Date arrivalDate, Integer numberOfBed,
		String typeOfRoom) {
	super();
	this.hotelReservationId = hotelReservationId;
	this.state = state;
	this.departureDate = departureDate;
	this.arrivalDate = arrivalDate;
	this.numberOfBed = numberOfBed;
	this.typeOfRoom = typeOfRoom;
}
@EmbeddedId
public HotelReservationId getHotelReservationId() {
	return hotelReservationId;
}

public void setHotelReservationId(HotelReservationId hotelReservationId) {
	this.hotelReservationId = hotelReservationId;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public Date getDepartureDate() {
	return departureDate;
}

public void setDepartureDate(Date departureDate) {
	this.departureDate = departureDate;
}

public Date getArrivalDate() {
	return arrivalDate;
}

public void setArrivalDate(Date arrivalDate) {
	this.arrivalDate = arrivalDate;
}

public Integer getNumberOfBed() {
	return numberOfBed;
}

public void setNumberOfBed(Integer numberOfBed) {
	this.numberOfBed = numberOfBed;
}

public String getTypeOfRoom() {
	return typeOfRoom;
}

public void setTypeOfRoom(String typeOfRoom) {
	this.typeOfRoom = typeOfRoom;
}


}
