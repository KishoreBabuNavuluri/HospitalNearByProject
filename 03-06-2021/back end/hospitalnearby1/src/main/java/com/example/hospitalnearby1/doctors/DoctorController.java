package com.example.hospitalnearby1.doctors;
import java.io.Console;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
	
	@Autowired
	DoctorService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/doctor/add/{spec}")
	public DoctorDTO insertDoctors(@PathVariable("spec") String spec, @RequestBody Doctors doctors) {
		Doctors doctor = service.insertDoctorsIntoDB(spec, doctors);
		DoctorDTO doc=this.getDoctorDTO(doctor);
		doc.setSplName(doctor.getSpec().getSplName());
		return doc;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/doctor/get/{spec}")
	public List<DoctorDTO> getDoctorsList(@PathVariable("spec") String spec) {
		List<Doctors> doctors=service.getDoctorsOfSpecialization(spec);
		List<DoctorDTO> doctorsList=new ArrayList<>();
		for(Doctors doctor: doctors) {
			DoctorDTO doc=this.getDoctorDTO(doctor);
			doc.setSplName(service.getSpecialization(spec).getSplName());
			doctorsList.add(doc);
		}
		return doctorsList;
	}
	

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/doctor/delete/{id}")
	public void deleteDoctor(@PathVariable("id") Long id) {
		
		if(service.deleteDoctors(id)) {
			System.out.println("deleted successfully");
		}
		
		else {
			System.out.println("The id not exist");
		}
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/doctor/singledoctor/{id}")
	public DoctorDTO getDoctor(@PathVariable("id") Long id) {
		Doctors doctorUsingId = service.getDoctorUsingId(id);
		DoctorDTO doctor=this.getDoctorDTO(doctorUsingId);
		doctor.setSplName(doctorUsingId.getSpec().getSplName());
		return doctor;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/doctor/update/{id}")
	public DoctorDTO updateDoctor(@PathVariable("id") Long id, @RequestBody Doctors doctor) {
		Doctors updateDoctors = service.updateDoctors(id, doctor);
		System.out.println(updateDoctors.getDoctorName());
		DoctorDTO doc=this.getDoctorDTO(updateDoctors);
		return doc;
	}
	
	public DoctorDTO getDoctorDTO(Doctors doctor) {
		DoctorDTO doc=new DoctorDTO();
		doc.setDoctorId(doctor.getDoctorId());
		doc.setDoctorName(doctor.getDoctorName());
		doc.setExperience(doctor.getExperience());
		doc.setNoOfOperationsTaken(doctor.getNoOfOperationsTaken());
		doc.setOperationsSuccess(doctor.getOperationsSuccess());
		doc.setSuccessRatio((float) doctor.getOperationsSuccess() / doctor.getNoOfOperationsTaken());
		return doc;
	}
	

}
/*{
"doctorName":"harinath",
"experience":7,
"noOfOperationsTaken":50,
"operationsSuccess":25
}*/