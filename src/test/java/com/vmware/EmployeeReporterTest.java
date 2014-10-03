package com.vmware;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import static org.easymock.EasyMock.*;

public class EmployeeReporterTest {
	
	@Test
	public void testOutputReport() throws IOException {
	    
		 //1. Set up the mocks
		 Writer writer = createMock(Writer.class);
		 Employee employee1 = createMock(Employee.class);
		 Employee employee2 = createMock(Employee.class);
		 
		 //2. Rehearse the mocks
		 expect(employee1.getName()).andReturn("VGopu");
		 expect(employee2.getName()).andReturn("Kareem");
		 expect(employee1.getPerformanceAverage()).andReturn(-2.65);
		 expect(employee2.getPerformanceAverage()).andReturn(-1.20);
		 
		 writer.write("Employee: VGopu, Performance Avg: -2.65");
		 writer.write("Employee: Kareem, Performance Avg: -1.2");
		 
		 //3. Replay
		 replay(employee1, employee2, writer);
		 
		 //4. Run the Test
		 List<Employee> employees = new ArrayList<Employee>();
		 employees.add(employee1);
		 employees.add(employee2);
		 
	     EmployeeReporter employeeReporter = new EmployeeReporter();
	     employeeReporter.printEmployees(employees, writer);
	     
	     //5. Verify
		 verify(employee1, employee2, writer);
	}
	
	
}
