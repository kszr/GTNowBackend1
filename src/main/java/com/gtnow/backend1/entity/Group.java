package entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A class representing a Group entity.
 */
@Entity
public class Group {
	@Id
	private Long groupId;
	private String gtIdCreator;
	private String name;
	private Date createTime;
	private int intervalExpire;
	
	private Group() {
		this.groupId = 0L;
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
			@JsonProperty("groupId") Long groupId,
			@JsonProperty("gtIdCreator") String gtIdCreator,
			@JsonProperty("name") String name,
			@JsonProperty("intervalExpire") int intervalExpire) {
		this.groupId = groupId;
		this.gtIdCreator = gtIdCreator;
		this.name = name;
		this.intervalExpire = intervalExpire;
	}
	
	public Long getGroupId() {
		return this.groupId;
	}
	
	public void setGroupId(Long groupId) {
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
	
	public Date getCreateTime() {
		return this.createTime;
	}
	
	public int getIntervalExpire() {
		return this.intervalExpire;
	}
	
	public void setIntervalExpire(int intervalExpire) {
		this.intervalExpire = intervalExpire;
	}
}
