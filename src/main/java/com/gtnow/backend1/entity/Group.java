package com.gtnow.backend1.entity;

import com.gtnow.backend1.object.Location;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.appengine.repackaged.org.joda.time.DateTime;
import com.google.common.base.Objects;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * A class representing a Group entity.
 */
@Entity
public class Group {
	@Id
	private String groupId;
	private String gtIdCreator;
	private String name;
	private DateTime createTime;
	private int intervalExpire;
	
	private Group() {
		this.groupId = null;
		this.gtIdCreator = null;
		this.name = null;
		this.createTime = null;
		this.intervalExpire = 0;
	}
	
	/**
	 * 
	 * @param groupId
	 * @param gtIdCreator
	 * @param name
	 * @param intervalExpire
	 * 
	 * @TODO Do something about createTime...
	 */
	@JsonCreator
	public Group(
			@JsonProperty("groupId") String groupId,
			@JsonProperty("gtIdCreator") String gtIdCreator,
			@JsonProperty("name") String name,
			@JsonProperty("intervalExpire") int intervalExpire) {
		this.groupId = groupId;
		this.gtIdCreator = gtIdCreator;
		this.name = name;
		this.intervalExpire = intervalExpire;
	}
	
	public String getGroupId() {
		return this.groupId;
	}
	
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
	public String getGtIdCreator() {
		return this.gtIdCreator;
	}

	public void setGtIdCreator(String gtIdCreator) {
		this.gtIdCreator = gtIdCreator;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public DateTime getCreateTime() {
		return this.createTime;
	}
	
	public int getIntervalExpire() {
		return this.intervalExpire;
	}
	
	public void setIntervalExpire(int intervalExpire) {
		this.intervalExpire = intervalExpire;
	}
}
