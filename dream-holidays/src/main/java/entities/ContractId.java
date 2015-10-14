package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ContractId implements Serializable{
private Integer clientId;
private Integer carId;

public ContractId() {
	super();
}

public ContractId(Integer clientId, Integer carId) {
	super();
	this.clientId = clientId;
	this.carId = carId;
}

public Integer getClientId() {
	return clientId;
}

public void setClientId(Integer clientId) {
	this.clientId = clientId;
}

public Integer getCarId() {
	return carId;
}

public void setCarId(Integer carId) {
	this.carId = carId;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((carId == null) ? 0 : carId.hashCode());
	result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
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
	ContractId other = (ContractId) obj;
	if (carId == null) {
		if (other.carId != null)
			return false;
	} else if (!carId.equals(other.carId))
		return false;
	if (clientId == null) {
		if (other.clientId != null)
			return false;
	} else if (!clientId.equals(other.clientId))
		return false;
	return true;
}

@Override
public String toString() {
	return "ContractId [clientId=" + clientId + ", carId=" + carId + "]";
}


}
