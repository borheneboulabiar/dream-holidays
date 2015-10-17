package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Position implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


private PositionId positionId;
private String currentPosition;

private Flight flight;
private Aeroport aeroport;

@ManyToOne
@JoinColumn(name = "flightId", referencedColumnName = "id", updatable = false, insertable = false)
public Flight getFlight() {
	return flight;
}

public void setFlight(Flight flight) {
	this.flight = flight;
}
@ManyToOne
@JoinColumn(name = "aeroportId", referencedColumnName = "id", updatable = false, insertable = false)
public Aeroport getAeroport() {
	return aeroport;
}

public void setAeroport(Aeroport aeroport) {
	this.aeroport = aeroport;
}

public Position() {
	super();
}

public Position(PositionId positionId, String currentPosition) {
	super();
	this.positionId = positionId;
	this.currentPosition = currentPosition;
}
@EmbeddedId
public PositionId getPositionId() {
	return positionId;
}

public void setPositionId(PositionId positionId) {
	this.positionId = positionId;
}

public String getCurrentPosition() {
	return currentPosition;
}

public void setCurrentPosition(String currentPosition) {
	this.currentPosition = currentPosition;
}


}
