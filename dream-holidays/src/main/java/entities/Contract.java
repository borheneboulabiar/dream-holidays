package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Contract implements Serializable{


private ContractId contractId;
private Date startDate;
private Date endDate;
private Double price;

private Client client;
private Car car;


@ManyToOne
@JoinColumn(name = "clientId", referencedColumnName = "id", updatable = false, insertable = false)
public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}
@ManyToOne
@JoinColumn(name = "carId", referencedColumnName = "id", updatable = false, insertable = false)
public Car getCar() {
	return car;
}

public void setCar(Car car) {
	this.car = car;
}

public Contract() {
	super();
}

public Contract(ContractId contractId, Date startDate, Date endDate,
		Double price) {
	super();
	this.contractId = contractId;
	this.startDate = startDate;
	this.endDate = endDate;
	this.price = price;
}

@EmbeddedId
public ContractId getContractId() {
	return contractId;
}

public void setContractId(ContractId contractId) {
	this.contractId = contractId;
}

public Date getStartDate() {
	return startDate;
}

public void setStartDate(Date startDate) {
	this.startDate = startDate;
}

public Date getEndDate() {
	return endDate;
}

public void setEndDate(Date endDate) {
	this.endDate = endDate;
}

public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}


}
