package com.gtnow.backend1.entity;

import com.gtnow.backend1.object.Location;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.appengine.repackaged.org.joda.time.DateTime;
import com.google.common.base.Objects;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * A class representing a User entity.
 */
@Entity
public class User {
    @Id
    private String id;
    private String name;
    private String gmailId;
    private Location location;
    private String locationReportTime; //The time at which the User's location was last updated.

    private User() {
        this.id = null;
        this.name = null;
        this.gmailId = null;
        this.location = null;
        this.locationReportTime = null;
    }

    @JsonCreator
    public User(
    	@JsonProperty("id") String id,
    	@JsonProperty("name") String name,
    	@JsonProperty("gmailId") String gmailId,
    	@JsonProperty("latitude") Double latitude,
    	@JsonProperty("longitude") Double longitude,
    	@JsonProperty("locationReportTime") String locationReportTime
    ) {
        this.id = id;
        this.name = name;
        this.gmailId = gmailId;
        this.location = new Location(latitude, longitude);
        this.updateLocationReportTime();
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGmailId() {
        return gmailId;
    }

    public void setGmailId(String gmailId) {
        this.gmailId = gmailId;
    }
    
    public Location getLocation() {
    	return this.location;
    }
    
    public void setLocation(Location location) {
    	this.location = location;
    }

    public String getLocationReportTime() {
    	return this.locationReportTime;
    }
    
    public void setLocationReportTime(String locationReportTime) {
    	this.locationReportTime = locationReportTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equal(id, user.id) &&
            Objects.equal(name, user.name) &&
            Objects.equal(gmailId, user.gmailId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, gmailId);
    }
}
