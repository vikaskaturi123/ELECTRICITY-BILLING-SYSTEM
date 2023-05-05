package com.electricitybillingsystem.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.electricitybillingsystem.entity.BillCalculation;
import com.electricitybillingsystem.entity.Data;
import com.electricitybillingsystem.entity.GetLoginData;
import com.electricitybillingsystem.service.Userservice;

import jakarta.servlet.http.HttpSession;

 

@Controller
public class EmpControler {
	int Units=0;
	
	@Autowired
	public Userservice service;
	
	@GetMapping("/")
	public String index( org.springframework.ui.Model m){
		
		  List<Data> user=service.GetAllUserData(); 
		  m.addAttribute("user",user);
		return "index";
	}
	
	@GetMapping("/Search")
	public String search( org.springframework.ui.Model m,String search){
		 System.out.println(search);
		  List<Data> user=service.GetAllSearchData(search); 
		  m.addAttribute("user",user);
		  return "index";
	}
	
	@GetMapping("/Home")
	public String Home() {
		return "Home";
	}
	
	@GetMapping("/Login")
	public String home(){
		return "Login";
	}
	
	@PostMapping("/LoginRig")
	public String Login(@ModelAttribute GetLoginData a){
		System.out.println(a.getUsername().equals("admin123") && a.getPassword().equals("123"));
		if(a.getChar_ID().equals("Admin"))
		{
			if(a.getUsername().equals("admin123") && a.getPassword().equals("123"))
			{
				return "redirect:/";
			}
			else
			{
				return "Login";
			}
		}
		if(a.getChar_ID().equals("User") )
		{
			return "redirect:/Login";
		}
		else if(a.getUsername().equals("User"))
		{
			return "redirect:/Login"; 
		}
		System.out.println(a);
	  return "redirect:/";
	}
	
	@GetMapping("/Sigin-in")
	public String Sigin() {
		return "Sigin-in";
	}
	
	@PostMapping("/register")
    public String Registration(@ModelAttribute Data d) {
		System.out.println(d);
		service.addUser(d);
		return"redirect:/";
	}
	
	@GetMapping("/Edit{ID}")
	public String Edit(@PathVariable int ID,Model m)
	{
		Data d=service.GetUSER_DATAByID(ID);
		Units=d.getUnits();
		m.addAttribute("USER_DATA", d);
		
		return"/Edit";
	}
	
	@PostMapping("/update")
	public String updateUSER_DATA(@ModelAttribute Data d, HttpSession session)
	{
		d.setUnits(Units+d.getUnits());
		int amount=BillCalculation.BillAmount(d.getUnits());
		d.setAmount(amount);
		service.addUser(d);
		session.setAttribute("msg","user data updated succesfully....");
		return "redirect:/";
	}
	@GetMapping("/Delete{ID}")
	public String DeleteUSER_DATA(@PathVariable int ID,HttpSession session) {
		
		service.DeleteUSER_DATA(ID);
		session.setAttribute("msg","user data Delete succesfully....");
		return"redirect:/";
	}

}
