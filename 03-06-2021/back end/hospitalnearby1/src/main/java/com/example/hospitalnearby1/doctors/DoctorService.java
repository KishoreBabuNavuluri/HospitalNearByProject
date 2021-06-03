package com.example.hospitalnearby1.doctors;

import java.util.List;

import com.example.hospitalnearby1.specialization.Specialization;

public interface DoctorService {

	public Doctors insertDoctorsIntoDB(String spec, Doctors doctors);
	public List<Doctors> getDoctorsOfSpecialization(String spec);
	public Doctors getDoctorUsingId(Long id);
	public boolean deleteDoctors(Long id);
	public Doctors updateDoctors(Long id, Doctors doctor);
	public Specialization getSpecialization(String spec);
}
