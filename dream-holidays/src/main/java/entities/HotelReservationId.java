package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class HotelReservationId implements Serializable{
private Integer clientId;
private Integer hotelId;

public HotelReservationId() {
	super();
}

public HotelReservationId(Integer clientId, Integer hotelId) {
	super();
	this.clientId = clientId;
	this.hotelId = hotelId;
}

public Integer getClientId() {
	return clientId;
}

public void setClientId(Integer clientId) {
	this.clientId = clientId;
}

public Integer getHotelId() {
	return hotelId;
}

public void setHotelId(Integer hotelId) {
	this.hotelId = hotelId;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
	result = prime * result + ((hotelId == null) ? 0 : hotelId.hashCode());
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
	HotelReservationId other = (HotelReservationId) obj;
	if (clientId == null) {
		if (other.clientId != null)
			return false;
	} else if (!clientId.equals(other.clientId))
		return false;
	if (hotelId == null) {
		if (other.hotelId != null)
			return false;
	} else if (!hotelId.equals(other.hotelId))
		return false;
	return true;
}

@Override
public String toString() {
	return "HotelReservationId [clientId=" + clientId + ", hotelId=" + hotelId
			+ "]";
}


}
