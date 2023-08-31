package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Invitations;
import com.example.demo.service.InvitationService;

@RestController
public class InvitationsController {
	@Autowired
	InvitationService d;
	
	@PostMapping("addinvitations")
	public List<Invitations> add1(@RequestBody List<Invitations> i)
	{
		return d.savedetails3(i);
	}
	
	@GetMapping("showdetails3")
	public List<Invitations> show3(){
		return d.showinfo3();
	}
	
	@GetMapping("showid3/{id}")
	public Optional<Invitations> showid3(@PathVariable int id)
	{
		return d.showbyid3(id);
	}
	
	@PutMapping("update3")
	public Invitations modify3(@RequestBody Invitations i)
	{
		return d.changeinfo3(i);
	}
	
	@PutMapping("updatebyid3/{id}")
	public String change1(@PathVariable int id , @RequestBody Invitations i) 
	{
		return d.updateinfobyid3(id,i);
	}
	
	@DeleteMapping("delete3")
	public String del1(@RequestBody Invitations i)
	{
		 d.deleteinfo3(i);
		 return  "Deleted Suceessfully";
	}
	
	@DeleteMapping("del3/{id}")
	public void deletemyid1(@PathVariable int id)
	{
		d.deleteid3(id);
	}
	@PostMapping("addmeet")
	public Invitations addmeetdet(@RequestBody Invitations it)
	{
		return d.savemeetinfo(it);
	}

	@PostMapping("addnmeet")
	public List<Invitations> addnmeetdet(@RequestBody List<Invitations> it)
	{
		return d.savemeetdetails(it);
	}
	
    
	@GetMapping("showmeet")
   public List<Invitations> showmeetdet()
   {
	   return d.showmeetinfo();
   }
	
	
	
	
	
	
	
	
	
	//query 
	@GetMapping("/getnew/{invitationid}/{recipient_email}")
	public List<Invitations> displayalldet(@PathVariable int invitationid,@PathVariable String recipient_email)
	{
		return d.getdetails(invitationid,recipient_email);
	}

	//paging 
		@GetMapping("paging/{pageno}/{pagesize}")
		public List<Invitations> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize)
		{
			return d.getbypage(pageno,pagesize);
		}
		//sorting 
		@GetMapping("/sort/{invitation_status}")
		public List<Invitations> getsortinformation(@PathVariable String invitation_status)
		{
			return d.sortinformation(invitation_status);
		}
		
		
		
		

}
