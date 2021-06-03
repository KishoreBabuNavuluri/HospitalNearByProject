package com.example.hospitalnearby1.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hospitalnearby1.appointments.AppointmentDTO;
import com.example.hospitalnearby1.appointments.Appointments;
import com.example.hospitalnearby1.exception.UserNotFoundException;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/user/register")
	public UserDTO insertUser(@RequestBody User user) {
		UserDTO user1=null;
		if (service.isExistInDB(user)) {
			return user1;
		} else {
			User addUserDetails = service.addUserDetailsInDB(user);
			user1=this.getUserDTO(addUserDetails);
			return user1;
		}
		
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/user/login")
	public UserDTO userLoginValidation(@RequestBody User user) {
		UserDTO user1=null;
		User validUser = service.isValidUser(user); 
		if(validUser!=null)
			user1=this.getUserDTO(validUser);
		return user1;
			
	}

	private UserDTO getUserDTO(User loggeduser) {

		UserDTO user=new UserDTO();
		user.setId(loggeduser.getId());
		user.setName(loggeduser.getName());
		user.setPassword(loggeduser.getPassword());
		user.setEmail(loggeduser.getEmail());
		return user;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/user/appointments/{id}")
	public List<AppointmentDTO> appointments(@PathVariable("id") Long id) throws UserNotFoundException {
		List<Appointments> apps = service.getAppointments(id);
		List<AppointmentDTO> appointments = null;
		if (apps != null) {
			appointments = new ArrayList<AppointmentDTO>();
			for (Appointments appointment : apps) {
				AppointmentDTO app = new AppointmentDTO();
				app.setAppointmentDate(appointment.getAppointmentDate());
				app.setAppointmentTime(appointment.getAppointmentTime());
				app.setUserName(appointment.getUser().getName());
				app.setDoctorName(appointment.getDoctors().getDoctorName());
				app.setDepartment(appointment.getDoctors().getSpec().getSplName());
				appointments.add(app);
			}
		}
		System.out.println(appointments);
		return appointments;
	}
}

//{
//"name":"harsha", 
//"password":"harsha123", 
//"email":"gvsshhrao1998@gmail.com"
//}