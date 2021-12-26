package entities;

import java.util.Date;

public class Position {
	private int id;
	private double latitude;
	private double longitude;
	private Date date;
	private Tracker tracker;
	public Position(int id, double latitude, double longitude, Date date) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.date = date;
		this.tracker = tracker;
	}
        
	public Position(int id, double latitude, double longitude, Date date, Tracker tracker) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.date = date;
		this.tracker = tracker;
	}
	public Position(double latitude, double longitude, Date date, Tracker tracker) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.date = date;
		this.tracker = tracker;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Tracker getTracker() {
		return tracker;
	}
	public void setTracker(Tracker tracker) {
		this.tracker = tracker;
	}
	@Override
	public String toString() {
		return "Position [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", date=" + date
				+ ", tracker=" + tracker + "]";
	}
	
	

}
