package com.nwmortgage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.nwmortgage.dao.RegisterRepo;
import com.nwmortgage.exception.UserAlreadyExists;
import com.nwmortgage.exception.UserNotFound;
import com.nwmortgage.model.Register;



@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterRepo userRepository;
	@Override
	public Register addUser(Register user) throws UserAlreadyExists {
		Optional<Register> optuser = userRepository.findById(user.getCustid());
		if(optuser.isPresent()) {
			throw new UserAlreadyExists("User Already Exists.");
		} else {
			
			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			user.setPassword(bcrypt.encode(user.getPassword()));
			user.setPin(bcrypt.encode(user.getPin()));
			Register values = userRepository.save(user); 
			return values;
		}

	}

	@Override
	public List<Register> userList() {
		// TODO Auto-generated method stub
		List<Register> userlist = (List<Register>) userRepository.findAll();
		return userlist;

	}

	@Override
	public Register updateUser(Register user) {
		Register values = userRepository.save(user);   
		return values;
		
	}

	@Override
	public Register getByCustid(int custid) throws UserNotFound {
	    return userRepository.findById(custid)
	            .orElseThrow(() -> new UserNotFound("User not found"));
	}

}

