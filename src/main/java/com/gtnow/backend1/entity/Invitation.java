package com.gtnow.backend1.entity;

import com.gtnow.backend1.object.Location;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.appengine.repackaged.org.joda.time.DateTime;
import com.google.common.base.Objects;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

/**
 * A class representing an Invitation entity.
 */
@Entity
public class Invitation {
	@Id
	private Long invitationId;
	private User recipient; //Recipient of the Invitation.
	private User invitedBy; //Originator of the Invitation.
	private Group group;	//The Group this Invitation concerns.
	private DateTime inviteTime;//The time at which this Invitation was sent.
	private boolean accepted;
	private int flag;
	
	/**
	 * Values that flag can take:
	 * 0 - "Pending" - An invitation starts off in this state.
	 * 1 - "Accepted"- An invitation has been accepted.
	 * 2 - "Rejected"- An invitation has been rejected.
	 * 3 - "Deleted" - A User has been removed from the Group.
	 */
	
	private Invitation() {
		this.invitationId = 0L;
		this.recipient = null;
		this.invitedBy = null;
		this.group = null;
		this.inviteTime = null;
		this.accepted = false;
		this.flag = 0;
	}
	
	/**
	 * 
	 * @param invitationId
	 * @param recipient
	 * @param invitedBy
	 * @param group
	 * 
	 * @TODO Do something about inviteTime.
	 */
	@JsonCreator
	public Invitation(
			@JsonProperty("invitationId") Long invitationId,
			@JsonProperty("recipient") User recipient,
			@JsonProperty("invitedBy") User invitedBy,
			@JsonProperty("group") Group group
			) {
		this.invitationId = invitationId;
		this.recipient = recipient;
		this.invitedBy = invitedBy;
		this.group = group;
		
		this.accepted = false;
		this.flag = 0;		
	}
	
	public Long getInvitationId() {
		return this.invitationId;
	}
	
	public void setInvitationId(Long invitationId) {
		this.invitationId = invitationId;
	}
	
	public User getRecipient() {
		return this.recipient;
	}
	
	public void setRecipient(User recipient) {
		this.recipient = recipient;
	}
	
	public User getInvitedBy() {
		return this.invitedBy;
	}
	
	public void setInvitedBy(User invitedBy) {
		this.invitedBy = invitedBy;
	}
	
	public boolean isAccepted() {
		return accepted;
	}
	
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	
	public int getFlag() {
		return this.flag;
	}
	
	public void setFlag(int flag) {
		if(flag >= 0 && flag <= 3)
			this.flag = flag;
	}
}
