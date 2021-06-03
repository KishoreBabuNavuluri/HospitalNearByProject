package com.example.hospitalnearby1.specialization;

import java.util.List;

public interface SpecializationService {

	public Specialization addSpecilizationIntoDB(Specialization specialization);
	public List<Specialization> getAllSpecializations();
	public Specialization getSpecializationByName(String spec);
}
