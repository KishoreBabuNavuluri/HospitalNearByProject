package com.example.hospitalnearby1.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.hospitalnearby1.appointments.Appointments;
import com.example.hospitalnearby1.exception.UserNotFoundException;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	public boolean isExistInDB(User user) {
		User byId = this.getUsingName(user.getName());
		if(byId==null)
			return false;
		return true;
	}
	
	public User addUserDetailsInDB(User user) {
		return userRepository.save(user);
	}
	
	public User isValidUser(User user) {
		User byId = this.getUsingName(user.getName());
		if(isExistInDB(user) && byId.equals(user)) {
			return byId;
		}
		else {
			return null;
		}
	}
	
	public User getUser(Long id) throws UserNotFoundException {
		Optional<User> byId=userRepository.findById(id);
		if(!byId.isPresent()) {
			 throw new UserNotFoundException("The user with id - "+id+ " does not exists");
		}
		User user=userRepository.getById(id);
		return user;
	}

	public List<Appointments> getAppointments(Long id) throws UserNotFoundException {
		User user = this.getUser(id);
		List<Appointments> appointments=user.getAppointments();
		
		return appointments;
	}
	
	public User getUsingName(String name) {
		User byName = userRepository.getByName(name);
		return byName;
	}
}
