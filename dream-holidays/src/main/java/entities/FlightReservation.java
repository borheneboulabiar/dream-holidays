package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class FlightReservation implements Serializable{
private FlightReservationId flightReservationId;
private String seat;

private Flight flight;
private Client client;

@ManyToOne
@JoinColumn(name = "flightId", referencedColumnName = "id", updatable = false, insertable = false)
public Flight getFlight() {
	return flight;
}

public void setFlight(Flight flight) {
	this.flight = flight;
}
@ManyToOne
@JoinColumn(name = "clientId", referencedColumnName = "id", updatable = false, insertable = false)
public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}

public FlightReservation() {
	super();
}

public FlightReservation(Flight flight, Client client) {
	super();
	this.flight = flight;
	this.client = client;
}

public FlightReservation(FlightReservationId flightReservationId, String seat) {
	super();
	this.flightReservationId = flightReservationId;
	this.seat = seat;
}
@EmbeddedId
public FlightReservationId getFlightReservationId() {
	return flightReservationId;
}

public void setFlightReservationId(FlightReservationId flightReservationId) {
	this.flightReservationId = flightReservationId;
}

public String getSeat() {
	return seat;
}

public void setSeat(String seat) {
	this.seat = seat;
}


}
