package com.pmcderm.insapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurance_companies")
public class InsuranceCompany {

	@Id
	@Column(name="insurance_company_id")
	private long insuranceCompanyId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="website")
	private String website;

	public long getInsuranceCompanyId() {
		return insuranceCompanyId;
	}

	public void setInsuranceCompanyId(long insuranceCompanyId) {
		this.insuranceCompanyId = insuranceCompanyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "InsuranceCompany [insuranceCompanyId=" + insuranceCompanyId + ", companyName=" + companyName
				+ ", phoneNumber=" + phoneNumber + ", website=" + website + "]";
	}
	
	
	
}
