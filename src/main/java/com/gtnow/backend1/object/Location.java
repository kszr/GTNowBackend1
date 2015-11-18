package com.gtnow.backend1.object;

/**
 * A class used to represent locations.
 */
public class Location {
	private Double latitude;
	private Double longitude;
	
	private Location() {
		this.latitude = null;
		this.longitude = null;
	}
	
	public Location(Double latitude, Double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Double getLatitude() {
		return this.latitude;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public Double getLongitude() {
		return this.longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
}
