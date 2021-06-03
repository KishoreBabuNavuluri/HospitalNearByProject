package com.example.hospitalnearby1.appointments;

import java.time.LocalDate;

import com.example.hospitalnearby1.exception.UserNotFoundException;

public interface AppointmentService {

	public Appointments bookAppointment(Long userId, Long doctorId, Appointments appointments) throws UserNotFoundException;
	public void deleteDoctor(Long id);
	public boolean checkIsDateValid(LocalDate appointmentDate);
}
