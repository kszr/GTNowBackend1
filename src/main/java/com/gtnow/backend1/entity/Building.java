package com.gtnow.backend1.entity;

import com.gtnow.backend1.object.Location;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * A class representing a Building entity.
 */
@Entity
public class Building {
	@Id
	private Long buildingId;
	private String name;
	private String address;
	private Location location;
	
	private Building() {
		this.buildingId = null;
		this.name = null;
		this.address = null;
		this.location = null;
	}
	
	@JsonCreator
	public Building(
			@JsonProperty("buildingId") Long buildingId,
			@JsonProperty("name") String name,
			@JsonProperty("address") String address,
			@JsonProperty("latitude") Double latitude,
			@JsonProperty("longitude") Double longitude
			) {
		this.buildingId = buildingId;
		this.name = name;
		this.address = address;
		this.location = new Location(latitude, longitude);
	}
	
	public Long getBuildingId() {
		return this.buildingId;
	}
	
	public void setBuildingId(Long buildingId) {
		this.buildingId = buildingId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Building building = (Building) o;
        return Objects.equal(buildingId, building.buildingId) &&
            Objects.equal(name, building.name) &&
            Objects.equal(address, building.address);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(buildingId, name, address);
    }
}
