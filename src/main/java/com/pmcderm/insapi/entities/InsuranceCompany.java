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
	
	@Column(name="phone_comments")
	private String phoneComments;
	
	
	
	public InsuranceCompany() {
		
	}

	public InsuranceCompany(long insuranceCompanyId, String companyName, String phoneNumber, String website,
			String phoneComments) {
		super();
		this.insuranceCompanyId = insuranceCompanyId;
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.website = website;
		this.phoneComments = phoneComments;
	}

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

	public String getPhoneComments() {
		return phoneComments;
	}

	public void setPhoneComments(String phoneComments) {
		this.phoneComments = phoneComments;
	}

	@Override
	public String toString() {
		return "InsuranceCompany [insuranceCompanyId=" + insuranceCompanyId + ", companyName=" + companyName
				+ ", phoneNumber=" + phoneNumber + ", website=" + website + ", phoneComments=" + phoneComments + "]";
	}

	
	
	
	
}
