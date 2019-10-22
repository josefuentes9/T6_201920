package model.logic;

import java.util.List;

public class Geometry {
	
	private String type;
	
	private List<Coordinate> coordinates;
	

	
	
	public Geometry(String type, List<Coordinate> coordinates) {
		super();
		this.type = type;
		this.coordinates = coordinates;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public List<Coordinate> getCoordinates() {
		return coordinates;
	}
	
	public void setCoordinates(List<Coordinate> coordinates) {
		this.coordinates = coordinates;
	}
	
}