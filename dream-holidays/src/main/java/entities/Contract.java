package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
@Entity
public class Contract implements Serializable{
private ContractId contractId;
private Date startDate;
private Date endDate;
private Double price;

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
