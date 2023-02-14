package com.nwmortgage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.nwmortgage.dao.RegisterRepo;
import com.nwmortgage.model.Enquiry;

@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterRepo userRepository;

	@Override
	public Enquiry addUser(Enquiry user) {

		user.setAddress(user.getAddress());
		user.setEmail(user.getEmail());
		user.setMessage(user.getMessage());
		user.setName(user.getName());
		user.setPhoneno(user.getPhoneno());
		Enquiry values = userRepository.save(user);
		return values;
	}

	

	@Override
	public List<Enquiry> userList() {
		// TODO Auto-generated method stub
		List<Enquiry> userlist = (List<Enquiry>) userRepository.findAll();
		return userlist;

	}

	@Override
	public Enquiry updateUser(Enquiry user) {
		Enquiry values = userRepository.save(user);
		return values;

	}

	@Override
	public Optional<Enquiry> getBySno(int sno) {
		return userRepository.findById(sno);

	}

}
