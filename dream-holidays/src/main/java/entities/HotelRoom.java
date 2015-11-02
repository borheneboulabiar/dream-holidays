package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class HotelRoom implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int hotelid;
	private int id;
	
	public HotelRoom() {
		super();
	}

	public HotelRoom(Integer Hotelid, Integer id) {
		super();
		this.hotelid = Hotelid;
		this.id = id;
	}

	
	public int getHotelid() {
		return hotelid;
	}

	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

}
