package com.gtnow.backend1.entity;

import com.gtnow.backend1.object.Location;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.appengine.repackaged.org.joda.time.DateTime;
import com.google.common.base.Objects;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Event {
	@Id
	private String eventId;
	private String userId;
	private String eventScheduleId;
	private String name;
	private String description;
	private DateTime startTime;
	private DateTime endTime;
	private String buildingId;
	private boolean notified;
	private boolean active;
	
	private Event() {
		this.eventId = 0L;
		this.userId = 0L;
		this.eventScheduleId = 0L;
		this.name = null;
		this.description = null;
		this.startTime = null;
		this.endTime = null;
		this.buildingId = 0L;
		this.notified = false;
		this.active = false;
	}
	
	@JsonCreator
	public Event(
			@JsonProperty("eventId") String eventId,
			@JsonProperty("userId") String userId,
			@JsonProperty("eventScheduleId") String eventScheduleId,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description,
			@JsonProperty("startTime") DateTime startTime,
			@JsonProperty("endTime") DateTime endTime,
			@JsonProperty("buildingId") String buildingId
			) {
		this.eventId = eventId;
		this.userId = userId;
		this.eventScheduleId = eventScheduleId;
		this.name = name;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.buildingId = buildingId;
		
		this.notified = false;
		this.active = true;
	}
	
	public String getEventId() {
		return this.eventId;
	}
	
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getEventScheduleId() {
		return this.eventScheduleId;
	}
	
	public void setEventScheduleId(String eventScheduleId) {
		this.eventScheduleId = eventScheduleId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public DateTime getStartTime() {
		return this.startTime;
	}
	
	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}
	
	public DateTime getEndTime() {
		return this.endTime;
	}
	
	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}
	
	public String getBuildingId() {
		return this.buildingId;
	}
	
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	
	public boolean isNotified() {
		return this.notified;
	}
	
	public void setNotified(boolean notified) {
		this.notified = notified;
	}
	
	public boolean isActive() {
		return this.active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
}