package com.vmware;

public class Task {
	private int expectedDays;
	private int actualDays;

	public Task(String name, int expectedDays, int actualDays) {
		this.expectedDays = expectedDays;
		this.actualDays = actualDays;
	}

	public int getDifference() {
		return actualDays - expectedDays;
	}
}
