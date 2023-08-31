package com.example.demo.model;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="participants_table")
public class Participants {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int participantid;
	
	private int meetingid;
	
	private String status;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_userid")
	private Users uk;

	public Participants(int participantid, int meetingid, String status, Users uk) {
		super();
		this.participantid = participantid;
		this.meetingid = meetingid;
		this.status = status;
		this.uk = uk;
	}

	public Participants() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getParticipantid() {
		return participantid;
	}

	public void setParticipantid(int participantid) {
		this.participantid = participantid;
	}

	public int getMeetingid() {
		return meetingid;
	}

	public void setMeetingid(int meetingid) {
		this.meetingid = meetingid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Users getUk() {
		return uk;
	}

	public void setUk(Users uk) {
		this.uk = uk;
	}


	
}
