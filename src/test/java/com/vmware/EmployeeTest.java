package com.vmware;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

//F2 Brings up the helper
	//CTRL+F11 Run
	//CTRL+E Recent Files
	//F3 Jump to Source

public class EmployeeTest {

	@Test
	public void createEmployeeAndGetName() {
		Employee employee = new Employee();
		String name = "Ricardo Montalban";
		employee.setName(name);
		assertEquals(employee.getName(), name);
	}
	
	
	@Test
	public void addASocialSecurityNumber() {
		Employee employee = new Employee();
		employee.setSocialSecurityNumber("123-45-6789");
		assertEquals(employee.getSocialSecurityNumber(), "123-45-6789");
	}
	
	@Test
	public void addAnotherSocialSecurityNumber() {
		Employee employee = new Employee();
		employee.setSocialSecurityNumber("123-45-6710");
		assertEquals(employee.getSocialSecurityNumber(), "123-45-6710");
	}
	
	@Test
	public void fixDE30201_SocialSecurityMustBeACertainFormat() {
		String badSSN = "RamLikesThe49ers";
		Employee employee = new Employee();
		try {
		   employee.setSocialSecurityNumber(badSSN);
		   fail("This line should never have been reached");
		} catch (IllegalArgumentException iae) {
		   assertEquals(iae.getMessage(), "RamLikesThe49ers is not a valid social security number");
		}
	}
}












