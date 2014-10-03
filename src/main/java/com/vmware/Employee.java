package com.vmware;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Employee {
	private String name;
	private String ssn;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSocialSecurityNumber(String ssn) {
		Pattern pattern = Pattern.compile("\\d{3}-\\d{2}-\\d{4}");
		Matcher matcher = pattern.matcher(ssn);
		if (!(matcher.matches())) 
			throw new IllegalArgumentException(ssn + " is not a valid social security number");
		this.ssn = ssn;
	}

	public String getSocialSecurityNumber() {
		return ssn;
	}
}











