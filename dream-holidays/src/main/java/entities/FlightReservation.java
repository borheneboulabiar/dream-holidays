package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;

public class FlightReservation implements Serializable{
private FlightReservationId flightReservationId;
private String seat;

public FlightReservation() {
	super();
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
