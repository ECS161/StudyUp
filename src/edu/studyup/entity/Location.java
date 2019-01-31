package edu.studyup.entity;

public class Location {

	public final double lat;
	public final double lon;
	public final double[] bounds;

	public Location(double lat, double lon) {
		this(lat, lon, null);
	}

	public Location(double lat, double lon, double[] bounds) {
		this.lon = lon;
		this.lat = lat;
		this.bounds = bounds;
	}
	
	public double[] getBoundingBox() {
		return this.bounds;
	}
}
