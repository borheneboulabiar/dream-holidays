package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Car implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Integer id;
private String mark;
private String model;

private List<Contract> contracts;


@OneToMany(mappedBy = "car")
public List<Contract> getContracts() {
	return contracts;
}
public void setContracts(List<Contract> contracts) {
	this.contracts = contracts;
}
public Car() {
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

public String getMark() {
	return mark;
}

public void setMark(String mark) {
	this.mark = mark;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}


}
