package snotra.awsedukit.awsdynamicservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import snotra.awsedukit.awsdynamicservice.repository.SmellSamplesDAO;

@RestController
public class AdminController {
	

	@Autowired
	private SmellSamplesDAO smellSamplesRepository;

	// Need to add spring security, good enough for now
	// empty manually palce holder here
	@PostMapping("/admin/reset")
	public ResponseEntity<String> resetDatabase()
	{
		
		return ResponseEntity.ok("Database contents deleted: !");
	}
	
}
