package com.electricitybillingsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electricitybillingsystem.entity.Data;

@Repository /* is a mechanism for encapsulating store and search */
public interface Userrepo extends JpaRepository<Data, Integer>{

}
