package com.vmware;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class EmployeePerformanceService {
    private List<Employee> employeeList;
    private Comparator<Employee> comparator;
    
    public EmployeePerformanceService() {
    	employeeList = new ArrayList<Employee>();
        comparator = new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return new Double(o1.getPerformanceAverage()).compareTo(o2.getPerformanceAverage());
			}
        };
    }
    
	public void addEmployee(Employee employee) {
		employeeList.add(employee);	
	}

	public List<Employee> getTop2Performers() {
		Collections.sort(employeeList, comparator);
		return employeeList.subList(0,2); 
	}
}
