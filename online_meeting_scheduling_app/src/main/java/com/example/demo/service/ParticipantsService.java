package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.demo.model.Participants;
import com.example.demo.repository.ParticipantsRepo;

@Service
public class ParticipantsService {
	@Autowired
	
	ParticipantsRepo pr;
	//POST
	public List<Participants> savedetails2(List<Participants> p)
	{
		return (List<Participants>)pr.saveAll(p);
	}
	
	//GET
	public List<Participants> showinfo2(){
		return pr.findAll();
	}
	
	//GET BY ID
	public Optional<Participants> showbyid2(int id)
	{
		return pr.findById(id);
	}
	
	//PUT
	public Participants changeinfo2(Participants p)
	{
		return pr.saveAndFlush(p);
	}
	
	//PUT BY ID
	public String updateinfobyid2(int id,Participants p)
	{
		pr.saveAndFlush(p);
		if(pr.existsById(id))
		{
			return "Updated";
		}
		else
		{
			return "Enter valid id";
		}
	}
	
	//DELETE
	public void deleteinfo2(Participants p)
	{
		pr.delete(p);
	}
	//DELETE BY ID(PathVariable)
	public void deleteid2(int id)
	{
		pr.deleteById(id);
	}
	public List<Participants> saveuserinfo(List<Participants> p)
	{
		return (List<Participants>)pr.saveAll(p);
	}
	
    public List<Participants> showuserinfo()
    {
    	return pr.findAll();// retrieving the data that has been store in the database
    }

	//query 
	  public List<Participants> getpart(int s,String b)
		{
			return pr.getparticipantinfo(s,b);
		}
	//deleting:Query
		
		public int delpart(int participantid)
		{
			return pr.deleteparticipantInfo(participantid);
		}
		
		
		//updating:Query
		public int updatepart(int id,int id1)
	    {
	    	return pr.updateparticipantInfo(id, id1);
	    }
		
		public List<Participants> sortandpage(String name,int pgno,int pagesize)
	    {
	    	Sort sort = Sort.by(name).ascending();
	    	Page<Participants> p = pr.findAll(PageRequest.of(pgno, pagesize, sort));
	    	return p.getContent();
	    }
		
		
	
	
	

}
