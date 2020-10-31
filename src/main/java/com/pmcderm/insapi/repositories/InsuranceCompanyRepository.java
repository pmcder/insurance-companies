package com.pmcderm.insapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pmcderm.insapi.entities.InsuranceCompany;

public interface InsuranceCompanyRepository extends CrudRepository<InsuranceCompany, Long> {

}
