package com.pmcderm.insapi.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmcderm.insapi.dto.CompanyDto;
import com.pmcderm.insapi.entities.InsuranceCompany;
import com.pmcderm.insapi.services.InsuranceCompanyService;

@RestController
@RequestMapping("/api")
public class InsuranceCompanyController {
	
	InsuranceCompanyService insuranceCompanyService;
	
	private static final Logger logger = LogManager.getLogger(InsuranceCompanyController.class); 
	
	@Autowired
	public InsuranceCompanyController(InsuranceCompanyService insuranceCompanyService) {
		this.insuranceCompanyService = insuranceCompanyService;
	}
	
	@GetMapping("/company")
	public Optional<InsuranceCompany> findCompanyByName(@RequestParam(value="companyName", required=false)String companyName){
		return this.insuranceCompanyService.findCompanyByName(companyName);
	}
	
	@CrossOrigin(origins = "http://pmcderm.io")
	@GetMapping("/companies")
	public List<InsuranceCompany> findAll(){
		logger.info("accessed at: "+LocalDate.now());
		return this.insuranceCompanyService.findAll();
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(value = "/addCompany")
	public HttpStatus saveCompany(@RequestBody @Valid CompanyDto companyDto){
		this.insuranceCompanyService.addCompany(companyDto);
		return HttpStatus.CREATED;
	}
}
