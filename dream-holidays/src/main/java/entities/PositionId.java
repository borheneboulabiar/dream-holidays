package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PositionId implements Serializable{
private Integer flightId;
private Integer aeroportId;

public PositionId() {
	super();
}

public PositionId(Integer flightId, Integer aeroportId) {
	super();
	this.flightId = flightId;
	this.aeroportId = aeroportId;
}

public Integer getFlightId() {
	return flightId;
}

public void setFlightId(Integer flightId) {
	this.flightId = flightId;
}

public Integer getAeroportId() {
	return aeroportId;
}

public void setAeroportId(Integer aeroportId) {
	this.aeroportId = aeroportId;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
			+ ((aeroportId == null) ? 0 : aeroportId.hashCode());
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
	PositionId other = (PositionId) obj;
	if (aeroportId == null) {
		if (other.aeroportId != null)
			return false;
	} else if (!aeroportId.equals(other.aeroportId))
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
	return "PositionId [flightId=" + flightId + ", aeroportId=" + aeroportId
			+ "]";
}


}
