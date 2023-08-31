package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Invitations;

import jakarta.transaction.Transactional;

public interface InvitationRepo extends JpaRepository<Invitations, Integer>{
	@Query(value="select * from invitation_table where invitationid=:s or recipient_email=:sn",nativeQuery=true)
	public List<Invitations> getinvitationinfo(@Param("s") int invitationid,@Param("sn")String recipientemail);
	
	@Modifying
	@Transactional
	@Query(value="delete from invitation_table where invited_user_id=:s",nativeQuery=true)
	public int deleteinviteInfo(@Param("s") int invited_user_id);
	
	
	@Modifying
	@Transactional
	@Query(value="update invitation_table set invitationid=?1 where invitationid=?2",nativeQuery=true)
	public int updateinviteInfo(int newid,int oldid);
	
	
}