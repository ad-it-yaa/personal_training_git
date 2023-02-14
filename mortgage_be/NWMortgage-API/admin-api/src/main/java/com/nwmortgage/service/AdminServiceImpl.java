package com.nwmortgage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.nwmortgage.dao.AdminRepo;
import com.nwmortgage.exception.UserAlreadyExists;
import com.nwmortgage.exception.UserNotFound;
import com.nwmortgage.model.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminRepo userRepository;

	@Override
	public Admin addUser(Admin user) throws UserAlreadyExists {
		Optional<Admin> optuser = userRepository.findById(user.getEmpid());
		if (optuser.isPresent()) {
			throw new UserAlreadyExists("User Already Exists.");
		} else {

			BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
			user.setPassword(bcrypt.encode(user.getPassword()));
			Admin values = userRepository.save(user);
			return values;
		}

	}

	@Override
	public List<Admin> userList() {
		// TODO Auto-generated method stub
		List<Admin> userlist = (List<Admin>) userRepository.findAll();
		return userlist;

	}

	@Override
	public Admin updateUser(Admin user) {
		Admin values = userRepository.save(user);
		return values;

	}

	@Override
	public Admin getByEmpid(int empid) throws UserNotFound {
		return userRepository.findById(empid).orElseThrow(() -> new UserNotFound("User not found"));
	}

}
