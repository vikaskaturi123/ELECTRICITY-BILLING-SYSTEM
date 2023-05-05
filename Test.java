package com.electricitybillingsystem.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

public class Test {
	@Autowired
	private AdminData adminDataRepository;

	//@GetMapping("/admin-data")
	//public List<AdminData> getAdminData() {
	 //   return adminDataRepository.findAll();
	//}
}
