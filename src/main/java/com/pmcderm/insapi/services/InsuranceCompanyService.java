package com.pmcderm.insapi.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmcderm.insapi.dto.CompanyDto;
import com.pmcderm.insapi.entities.InsuranceCompany;
import com.pmcderm.insapi.repositories.InsuranceCompanyRepository;

@Service
public class InsuranceCompanyService {
	
	private InsuranceCompanyRepository insuranceCompanyRepository;
	
	@Autowired
	public InsuranceCompanyService(InsuranceCompanyRepository insuranceCompanyRepository) {
		this.insuranceCompanyRepository = insuranceCompanyRepository;
	}
	
	public Optional<InsuranceCompany> findCompanyByName(String companyName){
		return this.insuranceCompanyRepository.findByCompanyName(companyName);
	}
	
	public List<InsuranceCompany> findAll(){
		return (List<InsuranceCompany>) this.insuranceCompanyRepository.findAll();
	}
	
	public void addCompany(CompanyDto companyDto) {
		InsuranceCompany insuranceCompany = new InsuranceCompany();
		insuranceCompany.setInsuranceCompanyId(companyDto.getInsuranceCompanyId());
		insuranceCompany.setCompanyName(companyDto.getCompanyName());
		insuranceCompany.setPhoneNumber(companyDto.getPhoneNumber());
		insuranceCompany.setWebsite(companyDto.getWebsite());
		insuranceCompany.setPhoneComments(companyDto.getPhoneComments());
		this.insuranceCompanyRepository.save(insuranceCompany);
	}
	
	public void save(InsuranceCompany insuranceCompany) {
		this.insuranceCompanyRepository.save(insuranceCompany);
	}
}
