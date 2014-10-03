package com.vmware;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class EmployeeReporter {

	public void printEmployees(List<Employee> employees, Writer writer) throws IOException {
		for (Employee employee: employees) {
			writer.write("Employee: " + employee.getName() + ", Performance Avg: " + employee.getPerformanceAverage());
		}
	}
}
