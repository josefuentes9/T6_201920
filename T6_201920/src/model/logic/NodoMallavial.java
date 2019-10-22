package model.logic;

public class NodoMallavial 
{
	private int id;
	private double longitud;
	private double latitud;
	
	public NodoMallavial(String _id, String _longitud, String _latitud)
	{
		id=Integer.parseInt(_id);
		longitud=Double.parseDouble(_longitud);
		latitud=Double.parseDouble(_latitud);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
