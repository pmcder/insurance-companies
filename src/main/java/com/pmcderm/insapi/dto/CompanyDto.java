package com.pmcderm.insapi.dto;

import javax.validation.constraints.NotNull;

public class CompanyDto {
	
	
	private long insuranceCompanyId;
	
	@NotNull
	private String companyName;
	
	@NotNull
	private String phoneNumber;
	
	private String website;
	
	private String phoneComments;

	public CompanyDto(long insuranceCompanyId, String companyName, String phoneNumber, String website,
			String phoneComments) {
		super();
		this.insuranceCompanyId = insuranceCompanyId;
		this.companyName = companyName;
		this.phoneNumber = phoneNumber;
		this.website = website;
		this.phoneComments = phoneComments;
	}
	
	protected CompanyDto() {
		
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
	
	
}
