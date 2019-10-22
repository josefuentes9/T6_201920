package model.logic;

public class Coordinate {
	double longitud;
	 double latitud;
	 
 public Coordinate() {
		super();
		// TODO Auto-generated constructor stub
	}
public Coordinate(double longitud, double latitud) {
		super();
		this.longitud = longitud;
		this.latitud = latitud;
	}
public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

}
