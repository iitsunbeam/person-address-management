package com.tsystem.mgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsystem.mgmt.model.Address;

@Repository
public interface PersonAddressRepository extends JpaRepository<Address,Long> {
	
	List<Address> findByName(String name);

}
