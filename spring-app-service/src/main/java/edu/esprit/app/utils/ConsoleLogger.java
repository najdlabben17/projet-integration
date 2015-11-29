package edu.esprit.app.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleLogger implements CustomLogger {

	private String loggingClassName;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

	public ConsoleLogger(String name) {

		this.loggingClassName = name;
	}

	public String getLoggingClassName() {
		return loggingClassName;
	}

	public void setLoggingClassName(String loggingClassName) {
		this.loggingClassName = loggingClassName;
	}

	@Override
	public void log(String message) {

		System.out.println("[" + loggingClassName + "] : " + sdf.format(new Date()) + " : " + message);
	}

}
