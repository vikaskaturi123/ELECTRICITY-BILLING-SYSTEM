package com.electricitybillingsystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.electricitybillingsystem.entity.Data;

@Repository
public interface DataRepo extends CrudRepository<Data, Integer>{
	List<Data> findByID(int ID);

}
