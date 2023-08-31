package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.model.Participants;

import jakarta.transaction.Transactional;

public interface ParticipantsRepo extends JpaRepository<Participants, Integer> {
	@Query(value="select * from participants_table where participantid=:s or status=:sn",nativeQuery=true)
	public List<Participants> getparticipantinfo(@Param("s") int participantid,@Param("sn")String Status);
	
	@Modifying
	@Transactional
	@Query(value="delete from participants_table where participantid=:s",nativeQuery=true)
	public int deleteparticipantInfo(@Param("s") int participantid);
	
	
	@Modifying
	@Transactional
	@Query(value="update participants_table set participantid=?1 where participantid=?2",nativeQuery=true)
	public int updateparticipantInfo(int newid,int oldid);

}
