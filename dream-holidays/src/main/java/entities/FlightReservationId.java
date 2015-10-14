package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FlightReservationId implements Serializable{
private Integer clientId;
private Integer flightId;


public FlightReservationId() {
	super();
}

public FlightReservationId(Integer clientId, Integer flightId) {
	super();
	this.clientId = clientId;
	this.flightId = flightId;
	
}

public Integer getClientId() {
	return clientId;
}

public void setClientId(Integer clientId) {
	this.clientId = clientId;
}

public Integer getFlightId() {
	return flightId;
}

public void setFlightId(Integer flightId) {
	this.flightId = flightId;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
	result = prime * result + ((flightId == null) ? 0 : flightId.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	FlightReservationId other = (FlightReservationId) obj;
	if (clientId == null) {
		if (other.clientId != null)
			return false;
	} else if (!clientId.equals(other.clientId))
		return false;
	if (flightId == null) {
		if (other.flightId != null)
			return false;
	} else if (!flightId.equals(other.flightId))
		return false;
	
	return true;
}

@Override
public String toString() {
	return "FlightReservationId [clientId=" + clientId + ", flightId="
			+ flightId + "]";
}


}
