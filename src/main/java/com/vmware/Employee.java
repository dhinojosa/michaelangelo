package com.vmware;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Employee {
	private String name;
	private String ssn;
    private Pattern pattern;
    
	public Employee(Pattern pattern) {
		this.pattern = pattern;	
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSocialSecurityNumber(String ssn) {
		if (!(pattern.matcher(ssn).matches())) 
			throw new IllegalArgumentException(ssn + " is not a valid social security number");
		this.ssn = ssn;
	}

	public String getSocialSecurityNumber() {
		return ssn;
	}
}











