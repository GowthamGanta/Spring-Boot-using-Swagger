package com.rs.fer.participant.request;

public class SavePartcipantRequest {
	
	private int participantId;
	private int groupId;

	
	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}
	public int getParticipantId() {
		return participantId;
	}
	public int getGroupId() {
		return groupId;
	}
	
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
}
