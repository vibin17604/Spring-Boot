package com.example.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="invitation_table")
public class Invitations {
	@Id
	private int invitationid;

	private int invited_user_id;
	
	private String recipient_email;
	
	private String invitation_status;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_mid")
	private List<Meetings> mt;

	public Invitations(int invitationid, int invited_user_id, String recipient_email, String invitation_status,
			List<Meetings> mt) {
		super();
		this.invitationid = invitationid;
		this.invited_user_id = invited_user_id;
		this.recipient_email = recipient_email;
		this.invitation_status = invitation_status;
		this.mt = mt;
	}

	public Invitations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getInvitationid() {
		return invitationid;
	}

	public void setInvitationid(int invitationid) {
		this.invitationid = invitationid;
	}

	public int getInvited_user_id() {
		return invited_user_id;
	}

	public void setInvited_user_id(int invited_user_id) {
		this.invited_user_id = invited_user_id;
	}

	public String getRecipient_email() {
		return recipient_email;
	}

	public void setRecipient_email(String recipient_email) {
		this.recipient_email = recipient_email;
	}

	public String getInvitation_status() {
		return invitation_status;
	}

	public void setInvitation_status(String invitation_status) {
		this.invitation_status = invitation_status;
	}

	public List<Meetings> getMt() {
		return mt;
	}

	public void setMt(List<Meetings> mt) {
		this.mt = mt;
	}
	

	
	

}
