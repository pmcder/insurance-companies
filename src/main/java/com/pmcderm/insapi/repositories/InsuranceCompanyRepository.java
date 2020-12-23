package com.pmcderm.insapi.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.pmcderm.insapi.entities.InsuranceCompany;

public interface InsuranceCompanyRepository extends CrudRepository<InsuranceCompany, Long> {
	
	
	public Optional<InsuranceCompany> findByCompanyName(String companyName);
	
	
	
	
	
	
	
}
