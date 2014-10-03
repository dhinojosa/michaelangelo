package com.vmware;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Employee {
	private String name;
	private String ssn;
	private Pattern pattern;
	private List<Task> tasks;

	public Employee(Pattern pattern) {
		this.pattern = pattern;
		this.tasks = new ArrayList<Task>();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setSocialSecurityNumber(String ssn) {
		if (ssn.trim().equals(""))
			throw new IllegalArgumentException(
					"social security number cannot be blank");
		if (!(pattern.matcher(ssn).matches()))
			throw new IllegalArgumentException(ssn
					+ " is not a valid social security number");
		this.ssn = ssn;
	}

	public String getSocialSecurityNumber() {
		return ssn;
	}

	public void addTask(Task task) {
		this.tasks.add(task);
	}

	public List<Task> getTasks() {
		return tasks;
	}
	
	@Override
	public String toString() {
		return "Employee[" + name + "]";		
	}

	public double getPerformanceAverage() {
		double total = 0.0;
		for (Task task: getTasks()) {
			total += task.getDifference();
		}
		return total / getTasks().size();
	}
}
