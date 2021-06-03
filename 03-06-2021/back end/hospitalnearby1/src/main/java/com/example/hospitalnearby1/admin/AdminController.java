package com.example.hospitalnearby1.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/admin/login")
	public Admin adminLogin(@RequestBody Admin adminLogin) {
		if(adminLogin.getName().equals("admin") && adminLogin.getPassword().equals("admin")) {
			return adminLogin;
		}
		else {
			return null;
		}
	}
}
