package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Flight implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Integer id;
private Date departureDate;
private Date arrivalDate;
private Integer numberOfPlaces;

private List<FlightReservation> reservationsFlight;



public List<FlightReservation> getReservationsFlight() {
	return reservationsFlight;
}
public void setReservationsFlight(List<FlightReservation> reservationsFlight) {
	this.reservationsFlight = reservationsFlight;
}
public Flight() {
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

public Integer getNumberOfPlaces() {
	return numberOfPlaces;
}

public void setNumberOfPlaces(Integer numberOfPlaces) {
	this.numberOfPlaces = numberOfPlaces;
}


}
