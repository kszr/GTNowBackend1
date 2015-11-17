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
    private Long userId;
    private String name;
    private String gmailId;
    private Location location;
    private DateTime timeStampLastUpdated;

    private User() {
        this.userId = null;
        this.name = null;
        this.gmailId = null;
        this.location = null;
        this.timeStampLastUpdated = null;
    }

    @JsonCreator
    public User(
    	@JsonProperty("UserId") Long id,
    	@JsonProperty("Name") String name,
    	@JsonProperty("GmailId") String gmailId,
    	@JsonProperty("Latitude") Double latitude,
    	@JsonProperty("Longitude") Double longitude
    ) {
        this.userId = id;
        this.name = name;
        this.gmailId = gmailId;
        this.location = new Location(latitude, longitude);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equal(userId, user.userId) &&
            Objects.equal(name, user.name) &&
            Objects.equal(gmailId, user.gmailId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId, name, gmailId);
    }
}
