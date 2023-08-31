package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Invitations;
import com.example.demo.repository.InvitationRepo;

@Service
public class InvitationService {
	@Autowired
	InvitationRepo ir;
	
	//POST
		public List<Invitations> savedetails3(List<Invitations> i)
		{
			return (List<Invitations>)ir.saveAll(i);
		}
		
		//GET
		public List<Invitations> showinfo3(){
			return ir.findAll();
		}
		
		//GET BY ID
		public Optional<Invitations> showbyid3(int id)
		{
			return ir.findById(id);
		}
		
		//PUT
		public Invitations changeinfo3(Invitations i)
		{
			return ir.saveAndFlush(i);
		}
		
		//PUT BY ID
		public String updateinfobyid3(int id,Invitations i)
		{
			ir.saveAndFlush(i);
			if(ir.existsById(id))
			{
				return "Updated";
			}
			else
			{
				return "Enter valid id";
			}
		}
		
		//DELETE
		public void deleteinfo3(Invitations i)
		{
			ir.delete(i);
		}
		//DELETE BY ID(PathVariable)
		public void deleteid3(int id)
		{
			ir.deleteById(id);
		}
		
		 public Invitations savemeetinfo(Invitations it)
		   {
		    	return ir.save(it);//saving the data from repository into the database
		   }
		    public List<Invitations> savemeetdetails(List<Invitations> it)
		    {
		    	return (List<Invitations>) ir.saveAll(it);
		    }
		    public List<Invitations> showmeetinfo()
		    {
		    	return ir.findAll();// retrieving the data that has been store in the database
		    }
	    
		
			//query 
		  public List<Invitations> getdetails(int s,String b)
			{
				return ir.getinvitationinfo(s,b);
			}
		 
		    //paging
		    

			public List<Invitations> getbypage(int pgno,int pgsize)
			{
				Page<Invitations> p = ir.findAll(PageRequest.of(pgno, pgsize));
				return p.getContent();
			}
			
			//sorting 

			public List<Invitations> sortinformation(String s)
			{
				return ir.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
			}
			

			//deleting:Query
			
			public int delinvite(int invited_user_id)
			{
				return ir.deleteinviteInfo(invited_user_id);
			}
			
			
			//updating:Query
			public int updateinvite(int id,int id1)
		    {
		    	return ir.updateinviteInfo(id, id1);
		    }
			
			
		

}
