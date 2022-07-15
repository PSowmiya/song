package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Repository.UserRepository;
import com.example.demo.Entity.userDetails;
import com.example.demo.Service.UserService;
@Service
public class UserImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional
	public String saveUserDetails(userDetails userDetails) throws Exception {

		int emailCount = userRepository.countByEmail(userDetails.getEmail());
		if(emailCount>1) {
			return "email already present";
		}
		int phoneNoCount = userRepository.countByPhoneNo(userDetails.getPhoneNo());
		if(phoneNoCount>1) {
			return "phoneNo already present";
		}
		
		int passwordCount = userRepository.countByPassword(userDetails.getPassword());
		if(passwordCount>1) {
			return "password already present";
		}
		
			userDetails=userRepository.save(userDetails);
			if(userDetails.getId()>1) {
				return "User Detail Saved Successfully";
			}else {
				return "Something went wrong";
			}
	}

}
