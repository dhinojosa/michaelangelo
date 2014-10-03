package com.vmware;

import static org.testng.Assert.*;

import java.util.regex.Pattern;

import org.junit.Before;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//F2 Brings up the helper
	//CTRL+F11 Run
	//CTRL+E Recent Files
	//F3 Jump to Source

public class EmployeeTest {
	
	private Employee employee;
	
	@BeforeMethod
	public void setUp() {
	   employee = new Employee(Pattern.compile("\\d{3}-\\d{2}-\\d{4}"));	
	}
	
	@Test
	public void createEmployeeAndGetName() {
		String name = "Ricardo Montalban";
		employee.setName(name);
		assertEquals(employee.getName(), name);
	}
	
	@Test
	public void testToString() {
		String name = "Ricardo Montalban";
		employee.setName(name);
		assertEquals(employee.toString(), "Employee[Ricardo Montalban]");
	}
	
	@Test
	public void addASocialSecurityNumber() {
		employee.setSocialSecurityNumber("123-45-6789");
		assertEquals(employee.getSocialSecurityNumber(), "123-45-6789");
	}
	
	@Test
	public void addAnotherSocialSecurityNumber() {
		employee.setSocialSecurityNumber("123-45-6710");
		assertEquals(employee.getSocialSecurityNumber(), "123-45-6710");
	}
	
	
	@DataProvider(name="badSSNs")
	public Object[][] badSSNProvider() {
		return new Object[][] {
				{"djajssjs", "djajssjs is not a valid social security number"},
				{"RamLikesThe49ers", "RamLikesThe49ers is not a valid social security number"},
				{"1", "1 is not a valid social security number"},
				{"19", "19 is not a valid social security number"},
				{"   ", "social security number cannot be blank"},
				{"", "social security number cannot be blank"}
		};
	}
	
	
	@Test(dataProvider="badSSNs")
	public void fixDE30201_SocialSecurityMustBeACertainFormat(String badSSN, String expectedMessage) {
		try {
		   employee.setSocialSecurityNumber(badSSN);
		   fail("This line should never have been reached");
		} catch (IllegalArgumentException iae) {
		   assertEquals(iae.getMessage(), expectedMessage);
		}
	}
	
	@Test
	public void calculateAverageRam() {
		//ALT_SHIFT_A = Column Mode
		employee.setName("Ram");
		employee.addTask(new Task("Fix Bug",        4, 4)); //0
		employee.addTask(new Task("Changed Header", 1, 3)); //2
		employee.addTask(new Task("Fix Major Bug",  5, 1)); //-4
		employee.addTask(new Task("Fixed DE10203",  2, 3)); //1
		                                                    //avg: -.25
		
		assertEquals(employee.getPerformanceAverage(), -.25, 0.0);
	}
	
	@Test
	public void calculateAverageNipuna() {
		employee.setName("Nipuna");
		employee.addTask(new Task("Fix Major Bug",  2,  2)); //0
		employee.addTask(new Task("Changed Header", 10, 1)); //-9
		employee.addTask(new Task("Fix Major Bug",  4,  2)); //-2
		employee.addTask(new Task("Fixed DE10204",  2,  2)); //0
		                                                      //avg -2.75
	
		assertEquals(employee.getPerformanceAverage(), -2.75, 0.0);
	}
}












