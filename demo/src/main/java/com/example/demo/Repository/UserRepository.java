package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.userDetails;

public interface UserRepository extends JpaRepository <userDetails,Integer>{

	int countByEmail(String email);

	int countByPhoneNo(String phoneNo);

	int countByPassword(String password);

}
