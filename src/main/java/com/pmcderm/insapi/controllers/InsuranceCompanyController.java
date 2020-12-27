package com.pmcderm.insapi.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pmcderm.insapi.entities.InsuranceCompany;
import com.pmcderm.insapi.services.InsuranceCompanyService;

@RestController
@RequestMapping("/api")
public class InsuranceCompanyController {
	
	InsuranceCompanyService insuranceCompanyService;
	
	@Autowired
	public InsuranceCompanyController(InsuranceCompanyService insuranceCompanyService) {
		this.insuranceCompanyService = insuranceCompanyService;
	}
	
	@GetMapping("/company")
	public Optional<InsuranceCompany> findCompanyByName(@RequestParam(value="companyName", required=false)String companyName){
		return this.insuranceCompanyService.findCompanyByName(companyName);
	}
	
	@CrossOrigin(origins = "https://smooth-reading.surge.sh")
	@GetMapping("/companies")
	public List<InsuranceCompany> findAll(){
		return this.insuranceCompanyService.findAll();
	}
	
	@PostMapping(value = "/addCompany", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<Void> save(InsuranceCompany insuranceCompany){
	this.insuranceCompanyService.save(insuranceCompany);
	return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
