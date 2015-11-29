package edu.esprit.app.utils;

import java.util.Date;

public class PerformanceMonitoringAspect {

	private long startTime;
	private long endTime;

	public void startExecution() {

		startTime = new Date().getTime();
	}

	public void endExecution() {

		endTime = new Date().getTime();
		System.out.println("Execution duration: " + (endTime - startTime) + " millis");
	}

}
