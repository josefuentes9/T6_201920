package model.logic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feature {
	
	@SerializedName("type")
	@Expose
	private String type;
	@SerializedName("geometry")
	@Expose
	private Geometry geometry;
	@SerializedName("Properies")
	@Expose
	private Properties Property;
	


	public Feature(String type, Geometry geometry, Properties property ) {
	
		this.type = type;
		this.geometry = geometry;
		Property = property;
		
	}

	public Properties getProperty() {
		return Property;
	}

	public void setProperty(Properties property) {
		Property = property;
	}

	public String getType() {
	return type;
	}

	public void setType(String type) {
	this.type = type;
	}

	public Geometry getGeometry() {
	return geometry;
	}

	public void setGeometry(Geometry geometry) {
	this.geometry = geometry;
	}
}