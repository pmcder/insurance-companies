package com.pmcderm.insapi.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import com.pmcderm.insapi.entities.InsuranceCompany;

@SpringBootTest
@Transactional
public class InsuranceCompanyServiceIntegrationTest {
	
    @Autowired
    private InsuranceCompanyService service;
    @Test
    public void saveTest() {
    	InsuranceCompany insuranceCompany = new InsuranceCompany(999, "test company", "555 555 5555", "www.test.com", "this is a comment");
    	service.save(insuranceCompany);
    	assertEquals(service.findCompanyByName(insuranceCompany.getCompanyName()).get().getInsuranceCompanyId(),insuranceCompany.getInsuranceCompanyId());
    }
}
