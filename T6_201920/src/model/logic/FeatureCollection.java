package model.logic;

import java.util.List;

public class FeatureCollection {
	
	List<Feature> features;
	String type;
	public FeatureCollection(List<Feature> h,String g) {
		features=h;
		type=g;
		// TODO Auto-generated constructor stub
	}
	public List<Feature> getFeatures() {
		return features;
	}
	public void setFeatures(List<Feature> features) {
		this.features = features;
	}

}
