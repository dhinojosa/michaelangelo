package com.vmware;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class EmployeePerformanceServiceTest {
   
	@Test
	public void findTheTopTwoPerformingEmployees() {
		
		EmployeePerformanceService employeePerformanceService = 
				new EmployeePerformanceService();
		
		Pattern pattern = Pattern.compile("\\d{3}-\\d{2}-\\d{4}");
		
		Employee employee1 = new Employee(pattern);
		employee1.addTask(new Task("Fix Bug",        4, 4)); //0
		employee1.addTask(new Task("Changed Header", 1, 3)); //2
		employee1.addTask(new Task("Fix Major Bug",  5, 1)); //-4
		employee1.addTask(new Task("Fixed DE10203",  2, 3)); //1
		                                                     //avg: -.25
		
		Employee employee2 = new Employee(pattern);
		employee2.addTask(new Task("Fix Major Bug",  2,  2)); //0
		employee2.addTask(new Task("Changed Header", 10, 1)); //-9
		employee2.addTask(new Task("Fix Major Bug",  4,  2)); //-2
		employee2.addTask(new Task("Fixed DE10204",  2,  2)); //0
		                                                      //avg -2.75
		
		Employee employee3 = new Employee(pattern);
		employee3.addTask(new Task("Fix Major Bug", 4, 6)); //2
		employee3.addTask(new Task("Fixed DE10203", 4, 9)); //5
		                                                    //avg: 3.5
		
		Employee employee4 = new Employee(pattern);
		employee4.addTask(new Task("Fix Major Bug 5", 4, 2));  //-2
		employee4.addTask(new Task("Fixed DE10209", 4, 4));    //0
		employee4.addTask(new Task("Fix Major Bug 1", 1, 1));  //0
		employee4.addTask(new Task("Fixed DE10210", 9, 2));    //-7
		employee4.addTask(new Task("Fix Major Bug 5", 10, 6)); //-4
		employee4.addTask(new Task("Fixed DE10211", 2, 1));    //-1
		                                                       //avg: -2.33
		
		employeePerformanceService.addEmployee(employee1);
		employeePerformanceService.addEmployee(employee2);
		employeePerformanceService.addEmployee(employee3);
		employeePerformanceService.addEmployee(employee4);
		
		List<Employee> expectedEmployees = new ArrayList<Employee>();
		expectedEmployees.add(employee2);
		expectedEmployees.add(employee4);
		assertEquals(employeePerformanceService.getTop2Performers(), expectedEmployees); 
	}
}
