package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Flight implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date departureDate;
	private Date arrivalDate;
	private Integer numberOfPlaces;

	private List<FlightReservation> reservationsFlight;
	private List<Position> positions;
	private Aeroport aeroport;
	
	@ManyToOne
	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

	@OneToMany(mappedBy = "flight")
	public List<Position> getPositions() {
		return positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	@OneToMany(mappedBy = "flight")
	public List<FlightReservation> getReservationsFlight() {
		return reservationsFlight;
	}

	public void setReservationsFlight(List<FlightReservation> reservationsFlight) {
		this.reservationsFlight = reservationsFlight;
	}

	public Flight() {
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

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Integer getNumberOfPlaces() {
		return numberOfPlaces;
	}

	public void setNumberOfPlaces(Integer numberOfPlaces) {
		this.numberOfPlaces = numberOfPlaces;
	}

}
