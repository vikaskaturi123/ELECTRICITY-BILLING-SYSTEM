package com.electricitybillingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.electricitybillingsystem.entity.Data;
import com.electricitybillingsystem.repository.Userrepo;
import java.util.List;
import java.util.Optional;

@Service
public class Userservice {
	
	@Autowired
	private Userrepo repo;
	
	public void addUser(Data d) {
		
		repo.save(d);
	}
	
	public List<Data> GetAllUserData()
	{
		
		return repo.findAll();
		
	}
	
	public List<Data> GetAllSearchData(String search)
	{
		List<Data> x=null;
		if(search.equals(""))
		{
			return repo.findAll();
		}
		return x;
	}
	
	public Data GetUSER_DATAByID(int ID)
	{
		Optional<Data> d=repo.findById(ID);
		if(d.isPresent())
		{
			return d.get();
		}
		return null;
	}
	
	public void DeleteUSER_DATA(int ID)
	{
		repo.deleteById(ID);
	}


}
