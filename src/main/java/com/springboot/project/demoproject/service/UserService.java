package com.springboot.project.demoproject.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.project.demoproject.dto.User;
import com.springboot.project.demoproject.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	 UserRepository userRepository;

	public void save(User data) throws SQLException, Exception {
		userRepository.save(data);
		// TODO Auto-generated method stub
		
	}

	public void Update(User data) throws SQLException, Exception {
		userRepository.Update(data);
		// TODO Auto-generated method stub
		
	}

	public List<User> getAllUsers() throws SQLException, Exception {
		// TODO Auto-generated method stub
		return userRepository.getAllUsers();
	}

	public void deletevalue(Integer bookingId) throws Exception {
		userRepository.deletevalue(bookingId);
		// TODO Auto-generated method stub
		
	}

	public User getById(Integer bookingId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userRepository.getById(bookingId);
	}

	

	
	
}




