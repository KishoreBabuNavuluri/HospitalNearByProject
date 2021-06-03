package com.example.hospitalnearby1.user;

import java.util.List;

import com.example.hospitalnearby1.appointments.Appointments;
import com.example.hospitalnearby1.exception.UserNotFoundException;
public interface UserService {

	public boolean isExistInDB(User user);
	public User addUserDetailsInDB(User user);
	public User isValidUser(User user);
	public User getUser(Long id) throws UserNotFoundException;
	public List<Appointments> getAppointments(Long id) throws UserNotFoundException;
	public User getUsingName(String name);
}
