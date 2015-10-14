package entities;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Aeroport implements Serializable{
private Integer id;
private String town;

public Aeroport() {
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

public String getTown() {
	return town;
}

public void setTown(String town) {
	this.town = town;
}


}
