package entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.joda.time.DateTime;

@Entity
public class Event {
	@Id
	private Long eventId;
	private Long userId;
	private Long eventScheduleId;
	private String name;
	private String description;
	private DateTime startTime;
	private DateTime endTime;
	private Long buildingId;
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
			@JsonProperty("eventId") Long eventId,
			@JsonProperty("userId") Long userId,
			@JsonProperty("eventScheduleId") Long eventScheduleId,
			@JsonProperty("name") String name,
			@JsonProperty("description") String description,
			@JsonProperty("startTime") DateTime startTime,
			@JsonProperty("endTime") DateTime endTime,
			@JsonProperty("buildingId") Long buildingId
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
	
	public Long getEventId() {
		return this.eventId;
	}
	
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	
	public Long getUserId() {
		return this.userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getEventScheduleId() {
		return this.eventScheduleId;
	}
	
	public void setEventScheduleId(Long eventScheduleId) {
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
	
	public Long getBuildingId() {
		return this.buildingId;
	}
	
	public void setBuildingId(Long buildingId) {
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