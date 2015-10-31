package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Room implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private HotelRoom hotelRoomId;
	private float price;
	private Hotel hotel;
	
	public Room() {
		super();
	}
	
	public Room(HotelRoom hotelRoomId, float price, Hotel hotel) {
		super();
		this.hotelRoomId = hotelRoomId;
		this.price = price;
		this.hotel = hotel;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@EmbeddedId
	public HotelRoom getHotelRoomId() {
		return hotelRoomId;
	}
	public void setHotelRoomId(HotelRoom hotelRoomId) {
		this.hotelRoomId = hotelRoomId;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "hotelid", referencedColumnName = "id", updatable = false, insertable = false)
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	

}
